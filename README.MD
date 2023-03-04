# Do Users Watch TV Shows in Order?

This is a small project that will print the percentage of users who watch TV shows in order.
I was asked this question once almost a year ago and wanted to see if I could solve it.

The question involves being presented with a CSV file which contains the following:

```
User,Show,Season,Episode,Timestamp
1,1,1,1,1677760703000
1,1,1,2,1677760703002
1,1,1,3,1677760703004
```

Here it can be seen that user 1 did watch the show in order based on the timestamp and episode numbers.
There are many questions that come to mind when thinking about solving this problem.
I made a lot of assumptions in order to solve this problem as it appears here, but would
be interested in exploring various other requirements as well.

For example
* What should the behavior be if a user watches only 1 episode of a season? Does that count?
* What should the behavior be if a user watches a season in the following order: 1, 2, 4, 3, 5, 6, 7.  Here these are
  all in order except episodes 4 and 3.  Since most episodes were watched in order, does this count or no?

Note: this project only reads from the files in the src/main/resources directory, but it could be modified
to read files from elsewhere as well.

## Installation

Maven is required to run this project.  And Java.

```bash
mvn clean install
mvn exec:java -Dexec.mainClass=com.wright.App
```

## Algorithm Notes
This program follows the pseudocode below to determine if a viewer watched a TV series in order:

```
1.
for row in csv:
    parse the row
    add the row to an object
end for

2.
return the parsed object

3.
map each row (a TV episode with data) to an episode, season, show, user

4.
sort the seasons and the episodes based on the timestamp

5.
int didUserWatchInOrder = 0
for userViewingActivity in userViewings
    if (didUserWatchShowInOrder &&
            areSeasonsWatchedInOrder &&
            areEpisodesWatchedInOrder) {
        didUserWatchInOrder++
    }
end for

6.
return percentage based off of how many users watched in order out of the total users
```