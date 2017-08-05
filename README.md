# java-thetvdb
java-thetvdb is an unofficial java wrapper for the TheTVDB JSON-API (see https://api.thetvdb.com/swagger). 

## Usage
In order to access API-Calls we first have to create a TheTVDB account and setup a project at their site. Once an account and a project are set-up, the API- and User-Key can be obtained at the following page: http://thetvdb.com/?tab=userinfo. With those parameters we'll now create an TheTVDBAPI object ($USERNAME, $USERKEY and $APIKEY are the said parameters):
```java
TheTVDBAPI theTVDBAPI = TheTVDBAPI.getInstance("$USERNAME", "$USERKEY", "$APIKEY");
```
With the following object we can now:
* search for shows and see their description
* look up actors
* look up episodes
* look up images

### Searching for shows
In order to search for shows / series, we have to create an SearchResult object (better yet, a List). Let's take Game of Thrones for example.
```java
List<SearchResult> searchResults = theTVDBAPI.searchSeries("Game of Thrones");
for (SearchResult s : searchResults) {
    System.out.println(s.getSeriesName() + "; " + s.getSeriesId());
}
```
Output:
```
Game of Thrones; 121361
Game of Thrones: Cartoon Parody; 311939
Tribe of Hip Hop; 321282
```
The given ID (121361 for Game of Thrones) can then be used to look up the show for more details.
```java
Series gameOfThrones = theTVDBAPI.getSeries(121361);
System.out.println(
        gameOfThrones.getSeriesName()       + "; " +
        gameOfThrones.getSeriesNetwork()    + "; " +
        gameOfThrones.getSeriesId()         + "; " +
        gameOfThrones.getSeriesGenre().toString()
        /* etc... */
);
```
Output:
```
Game of Thrones; HBO; 121361; [Adventure, Drama, Fantasy]
```

### Looking up an Actor
In order to look up actors, we first need the series ID, with which we can then request a List of Actors of a series. Let's again take Game of Thrones as an example.
```java
List<Actor> actor = theTVDBAPI.getActors(121361);
for (Actor a : actor) {
    if (a.getActorName().equals("Emilia Clarke"))
        System.out.println(
                a.getActorName()    + "; " +
                a.getActorId()      + "; " +
                a.getActorRole()    + "; " +
                a.getImageUrl()
                /* etc... */
        );
}
```
Output:
```
Emilia Clarke; 346310; Daenerys Targaryen; https://thetvdb.com/banners/actors/346310.jpg
```

### Looking up Episodes
Episodes are usually bundled in Season object. This means, that we have a List of Seasons, which contain a List of Episodes. Again we will need the series ID in order to request seasons / episodes.
```java
List<Season> seasons = theTVDBAPI.getSeasons(121361);
List<Episode> episodes = seasons.get(1).getEpisodes();
for (Episode e : episodes) {
    System.out.println(
            e.getEpisodeName()          + "; " +
            e.getEpisodeFirstAired()    + "; " +
            e.getEpisodeId()            + "; "
            /* etc... */        
    );
}
```
Output:
```
Winter Is Coming; 2011-04-17; 3254641; 
The Kingsroad; 2011-04-24; 3436411; 
Lord Snow; 2011-05-01; 3436421; 
Cripples, Bastards, and Broken Things; 2011-05-08; 3436431; 
The Wolf and the Lion; 2011-05-15; 3436441; 
A Golden Crown; 2011-05-22; 3436451; 
You Win or You Die; 2011-05-29; 3436461; 
The Pointy End; 2011-06-05; 3360391; 
Baelor; 2011-06-12; 4063481; 
Fire and Blood; 2011-06-19; 4063491;
```
Note: with the given episodeId (3254641 for Winter is Coming) we can look up more details of an episode. This can be accomplished with an EpisodeDetailed object. 
```java
EpisodeDetailed episodeDetailed = theTVDBAPI.getSpecificEpisode(3254641);
System.out.println(
        episodeDetailed.getDirectors()      + "; " +
        episodeDetailed.getWriters()        + "; "
        /* etc... */
);
```
Output:
```
[Tim Van Patten]; [David Benioff, D. B. Weiss]; 
```

### Looking up Images
Lastly we can get some image URLs of specific series. For that we need the series ID and one of the given ImageTypes (= those are enums: Season, Poster, Series and Fanart). 
```java
List<Image> imageSeason = theTVDBAPI.getImages(121361, ImageType.SEASON);
List<Image> imagePoster = theTVDBAPI.getImages(121361, ImageType.POSTER);
List<Image> imageSeries = theTVDBAPI.getImages(121361, ImageType.SERIES);
List<Image> imageFanart = theTVDBAPI.getImages(121361, ImageType.FANART);

System.out.println("Season: " + imageSeason.get(0).getUrl());
System.out.println("Poster: " + imageFanart.get(0).getUrl());
System.out.println("Series: " + imageSeries.get(0).getUrl());
System.out.println("Fanart: " + imagePoster.get(0).getUrl());
```
Output:
```
Season: https://thetvdb.com/banners/seasons/121361-2-17.jpg
Poster: https://thetvdb.com/banners/fanart/original/121361-3.jpg
Series: https://thetvdb.com/banners/graphical/121361-g26.jpg
Fanart: https://thetvdb.com/banners/posters/121361-1.jpg
```
## Unsupported API calls
The following API calls are unsupported as of now, since I personally haven't found any usage for them (feel free to open an issue or pull request):   

| Path                               	| Description                                                                                                                                                                                                                                                       	| URL                                                                          	|   
|------------------------------------	|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|------------------------------------------------------------------------------	|
| /languages                         	| All available languages. These language abbreviations can be used in the "Accept-Language" header for routes that return translation records.                                                                                                                     	| https://api.thetvdb.com/swagger#!/Languages/get_languages                    	|
| /languages/{id}                    	| Information about a particular language, given the language ID.                                                                                                                                                                                                   	| https://api.thetvdb.com/swagger#!/Languages/get_languages_id                 	|
| /search/series/params              	| Returns an array of parameters to query by in the "/search/series" route.                                                                                                                                                                                         	| https://api.thetvdb.com/swagger#!/Search/get_search_series_params            	|
| /series/{id}/episodes/query        	| This route allows the user to query against episodes for the given,series. The response is a paginated array of episode records that have,been filtered down to basic information.                                                                                	| https://api.thetvdb.com/swagger#!/Series/get_series_id_episodes_query        	|
| /series/{id}/episodes/query/params 	| Returns the allowed query keys for the "/series/{id}/episodes/query" route                                                                                                                                                                                        	| https://api.thetvdb.com/swagger#!/Series/get_series_id_episodes_query_params 	|
| /series/{id}/episodes/summary      	| Returns a summary of the episodes and seasons available for the series. Note: Season "0" is for all episodes that are considered to be specials.                                                                                                                  	| https://api.thetvdb.com/swagger#!/Series/get_series_id_episodes_summary      	|
| /series/{id}/filter                	| Returns a series records, filtered by the supplied comma-separated list of keys. Query keys can be found at the "/series/{id}/filter/params" route.                                                                                                               	| https://api.thetvdb.com/swagger#!/Series/get_series_id_filter                	|
| /series/{id}/filter/params         	| Returns the list of keys available for the "/series/{id}/filter" route                                                                                                                                                                                            	| https://api.thetvdb.com/swagger#!/Series/get_series_id_filter_params         	|
| /series/{id}/images                	| Returns a summary of the images for a particular series                                                                                                                                                                                                           	| https://api.thetvdb.com/swagger#!/Series/get_series_id_images                	|
| /series/{id}/images/query/params   	| Returns the allowed query keys for the "/series/{id}/images/query" route. Contains a parameter record for each unique "keyType", listing values that will return results.                                                                                         	| https://api.thetvdb.com/swagger#!/Series/get_series_id_images_query_params   	|
| /updated/query                     	| Returns an array of series that have changed in a maximum of one week blocks since the provided "fromTime". The user may specify a "toTime" to grab results for less than a week. Any timespan larger than a week will be reduced down to one week automatically. 	| https://api.thetvdb.com/swagger#!/Updates/get_updated_query                  	|
| /updated/query/params              	| Returns an array of valid query keys for the "/updated/query/params" route.                                                                                                                                                                                       	| https://api.thetvdb.com/swagger#!/Updates/get_updated_query_params           	|
    
...and anything user-related.
