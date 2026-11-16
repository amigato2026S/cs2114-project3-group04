# cs2114-project3-group04
Hokie Burgeria - A fast food ordering kiosk using queues  
Model intended to be run in Eclipse IDE.  
Thin view: Test classes can be run as JUnit files.

**Reflection**  
*How did your design absorb the change?*  
Our main changes came from cookingClass, which mostly only interacts with FoodOrder. This was mostly anticipated because cookingClass is basically a separate part of the game that the player interacts with, and since the feature is non-trivial it doesn't really mess with any model classes.  
*Did the change cross the model/view line?*  
It didn't. As stated above, none of the model classes went through any major changes so the cookingClass didn't have to adapt to anything new. Other changes also didn't interfere with it.  
*What changed from your D3 plan?*  
The only change from the D3 plan was just the specifics of the feature we would actually changed. Last week, we weren't so sure with what exactly we would do with cookingClass, so throughout this week we went over what specifically we wanted to change about it so we could make our game more interesting. We ended up going with this feature because it was briefly discussed in our scope, but we weren't sure if we had the time to implement it, but since we had the opportunity we went ahead with it.  


**Next Steps**  
*What is left for the final build?*  






**Work Attribution**
| Class | Author | Progress | GenAI Note |
| :--- | :--- | :--- | :--- |
| PQueue | Ami | Wrote essential methods for PQueue | No AI used for this one |
| PQueueTest | Ami | Wrote test class for PQueue | Asked GenAI about necessary test cases |
| Main | Andrew | Wrote core application loop, menu routing, and input validation methods handling bad input cases  | Asked GenAI for structuring controller flow and handling bad input cases |
| Cooking | Nick | Wrote cooking class and cooking test class | AI used to make class and test class |
| Order | Armaan | Added the Order class that routed to the project.| No AI used for this one |

