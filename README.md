## Recommendation System

*...documentation in progress!*

This recommendation program uses a Collaborative Filtering system. The idea is to create recommendations specific to a user or rather than the same recommendations for all users. That's accomplished by finding similarities of ratings between a user and other users.


### Weighted Averages

The number of close raters is a parameter. You might use N equal to 10 to use 10 close raters. The second is the weight rating by a measure of how close a rater is to the user.

Which movie has the highest average?

ex.

|               | The Fly | Spider-Man | Butterfly Effect | Beetlejuice  |
| :------------ | :-----: | :--------: | :--------------: | :----------: |   
|   Chris  (20) |     8   |      5     |        7         |              |
|   Sam    (10) |         |      7     |        8         |      9       |
|   Morgan (5)  |     6   |      6     |        6         |      6       |
|   Average     | 14/2=7  |   18/3=6   |      21/3=7      |   15/2=7.5   |
|   weighted    | 160+30  | 100+70+30  |    140+80+30     |     90+30    |
|               |  95.0   |    66.67   |       83.3       |      60.0    |

Given the average rating, Beetlejuice is has the highest rate and in this case it should be recommended to the user. But if Chris is closer to the user than Morgan? Using weighted averages, these values changes based on closeness between users.  

Calculating the weights: (20*8 + 5*6)/2 + (5*20 + 10*7 + 5*6)/3 ...

Given the weighted averages, the recommended movie to watch is the Fly, different from the previous recommendation based solely on the average.

### Calculating Closeness using dot product.

ex.
* Each rater represented by vector of ratings
  - Sam    [0, 5, 2, 7, 0, 8, 1]
  - Chris  [6, 7, 5, 0, 0, 0, 9]
  - User   [2, 6, 0, 4, 5, 4, 6]

* Sam and user: 5*6 + 7*4 + 8*4 + 1*6 = 96
* Chris and user: 6*3 + 7*6 + 9*6 = 108

Sam is closer to the User than Chris. In this case we only use ratings from raters closer to the user.

To represent 1-10 scale, we have to adjust the ratings. Normalizing closer users who have rated movies 1 and 2 compared to 8 and 9. One way of doing that is centralizing the ratings subtracting by 5 (the median between 1-10)

In this case: (1-5) * (2-5) = 12, and (8-5) * (9-5) = 12

* Each rater represented by vector of ratings

  - Sam    [* , 0, -3, 2, * , 3, -4]
  - Chris  [1 , 2, 0, * , * , * , 4]
  - User   [-3, 1, * , -1, 0, -1, 1]

* Sam and user: 0*1 + 2*-1 + 3*-1 + -4*1 = -9
* Chris and user: -3*1 + 1*2 + 1*4 = 3

The case here, Chris and user is closer than user is to Sam, since a rate is a measure for closeness. In an non-centered ratings, Sam was the closer one.



The application can be found running [here](http://www.dukelearntoprogram.com/capstone/recommender.php?id=Rps2Qm01LkxMEX)
