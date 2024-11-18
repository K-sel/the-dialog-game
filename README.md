***TheDialogGame**
---
TheDialogGame is a text-based adventure game developed as part of a first-year Java course. This project emphasizes object-oriented programming (OOP) principles and integrates design patterns to create a modular and extensible game experience.

In this game, players explore a dynamic map, unlock new zones by solving puzzles, collect and interact with items, and progress through a rich narrative-driven journey.

Features

Gameplay

	•	Explore the Map: Travel across interconnected zones, unlocking new areas as you solve puzzles and progress through the story.
	•	Interact with Objects: Pick up, inspect, drop, or use items to solve challenges and advance.
	•	Solve Puzzles: Engage with riddles and clues to unlock new zones and unravel mysteries.
	•	Commands-Based Interface: Type commands like go, take, inspect, or solve to interact with the game world.

Technical Highlights

	•	Object-Oriented Design: Modular design using encapsulation, inheritance, and polymorphism.
	•	Design Patterns:
	•	Factory Pattern: For dynamically creating game objects (e.g., zones, puzzles, or items).
	•	Singleton Pattern: For managing the game state and player data.
	•	Strategy Pattern: For implementing different puzzle-solving mechanics.
	•	Text-Based Input System: Intuitive command system with clear feedback to guide the player.

Example Gameplay

Welcome to TheDialogGame!  
What is the name of your player?  
> K-sel  

Great to see you here, K-sel! You are currently at ile de dawn, the starting point of your adventure.  

Here’s the map:  
+-----------------------+-----------------------+-----------------------+-----------------------+  
|      ile de dawn      |      jaya's bar      |    thousand sunny    |      water seven      |  
+-----------------------+-----------------------+-----------------------+-----------------------+  
|       red line       |         kiri         |       loguetown       |       wano kuni       |  
+-----------------------+-----------------------+-----------------------+-----------------------+  
|     parc d'olympe     |        konoha        | village des forgerons |        skypea        |  
+-----------------------+-----------------------+-----------------------+-----------------------+  

Type `help` to see available commands.  

Available Commands

	•	go [north|south|east|west]: Move to adjacent zones on the map.
	•	take / take all: Pick up specific items or all items in a zone.
	•	inspect [item]: Examine an object for clues.
	•	solve [answer]: Attempt to solve a puzzle in the current zone.
	•	map: View the map and your current position. Locked zones appear in gray.
	•	inventory: Check your inventory and available space.
	•	look: Discover objects in the current zone.
	•	drop [item]: Remove items from your inventory (they remain in the zone).
	•	quit: Exit the game (note: no save functionality).

How to Run

	1.	Clone the repository:

git clone https://github.com/yourusername/thedialoggame.git  
cd thedialoggame  


	2.	Compile the Java files:

javac -d bin src/*.java  


	3.	Run the game:

java -cp bin Main  



Learnings

This project served as a practical application of OOP concepts and design patterns in a real-world scenario. It challenged us to think critically about game design, modularity, and scalability.

Feedback

If you have suggestions for improving the game mechanics, command system, or code structure, feel free to open an issue or submit a pull request!

Let me know if you’d like further refinements or additions!
