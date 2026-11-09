# cs2114-project3-group04
Hokie Burgeria - A fast food ordering kiosk using queues  
Model intended to be run in Eclipse IDE.  
Thin view: Test classes can be run as JUnit files.

**Reflection**  
*What changed from your specification?*  
Most changes from the test come from Order. Originally it was just going to be Order but we turned it into an interface for FoodOrder to implement.  
*Did the model really stand alone?*  
None of the models rely on Main, and test classes work individually as intended.  
*What happened to your unknowns?*  
We figured out the time, we figured out most(?) of the cooking side of the game.
*What doesn't work yet?*  
I think the Main class isn't fully coherent yet just because some of the model classes need fixing and polishing. 


**Next Steps**  
*What is left to finish the MVP?*  
We just have to make sure the full game actually fully runs and works for the whole time, and make sure all model classes work as intended.  
*Your change feature.*  
We didn't clarify much about the Cooking classes. We might change up the way players interact with cooking.
*Which stretch goals will you attempt?*  
We will try to work on priority circumstances since ours doesn't really fully work yet and could probably make it better.  
*What new tests will you need?*  
We can test Main by just running the code and making sure the game works, but otherwise we'll need to test cases for when we add priority circumstances or change up the cooking.  
*Who does what?*  
A lot of the essentials are put down, so instead of Armaan and Nick only working on their own classes we can all pitch in to start focusing on Main, FoodOrder, and Cooking.  

**Work Attribution**
| Class | Author | Progress | GenAI Note |
| :--- | :--- | :--- | :--- |
| PQueue | Ami | Wrote essential methods for PQueue | No AI used for this one |
| PQueueTest | Ami | Wrote test class for PQueue | Asked GenAI about necessary test cases |
| Main | Andrew | Wrote core application loop, menu routing, and input validation methods handling bad input cases  | Asked GenAI for structuring controller flow and handling bad input cases |
| Cooking | Nick | Wrote cooking class and cooking test class | AI used to make class and test class |
| Order | Armaan | Added the Order class that routed to the project.| No AI used for this one |

