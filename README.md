# Recommendation System

This recommendation program uses a Collaborative Filtering system. The idea is to create recommendations specific to a user rather than the same recommendations for all users. That's accomplished by finding similarities-of-ratings between a user and other users.

## Weighted Averages

The weighted averages are used to find movie recommendations. The weight in this case is based on how close a rater is to the user.

### Calculating Closeness using dot product.

ex.
* Each rater represented by vector of ratings
  - Sam    [0, 5, 2, 7, 0, 8, 1]
  - Chris  [6, 7, 5, 0, 0, 0, 9]
  - User   [2, 6, 0, 4, 5, 4, 6]

* Sam and user: (5 x 6) + (7 x 4) + (8 x 4) + (1 x 6) = 96
* Chris and user: (6 x 3) + (7 x 6) + (9 x 6) = 108

Sam is closer to the User than Chris. In this case we only use ratings from raters closer to the user.

In order to know what these ratings mean to each user, we need to normalize the ratings. To represent 1-10 scale, we have to adjust the ratings, normalizing closer users who have rated movies 1 and 2 compared to 8 and 9. One way of doing this is centralizing the ratings by subtracting 5 (the median between 1-10)

Therefore: (1 - 5) x (2 - 5) = 12, and (8 - 5) x (9 - 5) = 12

* Each rater represented by vector of ratings

  - Sam    [\* , 0, -3, 2, \* , 3, -4]
  - Chris  [1 , 2, 0, \* , \* , \* , 4]
  - User   [-3, 1, \* , -1, 0, -1, 1]

The star (\*) represents movies that weren't rated.

* Sam and user: (0 x 1) + (2 x -1) + (3 x -1) + (-4 x 1) = -9
* Chris and user: (-3 x 1) + (1 x 2) + (1 x 4) = 3

Since a rate is a measure for closeness, Chris and the user are closer than the user is to Sam. In a non-centered rating, Sam is the closer.

## Conclusion

While I'm aware this is just a simple recommendation system, it raised questions about things that could be problematic along the way, such as new users and sparse datasets. And so here are some observations based on my own conclusions, and research:

### Pros

This system works well once the user has already rated a few movies.

### Cons

New users will not get recommendations since they haven't yet rated any movies.

### Possible Solution

Two possible solutions for this case are:

1. Use a trending system that uses the most watched and highest rated movies by all users.  

2. Pair the Collaborative Filtering System with another system such as Content-based Recommendation that uses user's interests and movie attributes.

I'm working to further develop this project in Python, which can be found [here](https://github.com/bruno78/python-recommendation-system).

## Capstone Project

This is the capstone project for the [Java Programming and Software Engineering Fundamentals Specialization](https://www.coursera.org/specializations/java-programming) by Duke University.

The application can be found running [here](http://www.dukelearntoprogram.com/capstone/recommender.php?id=Rps2Qm01LkxMEX)
