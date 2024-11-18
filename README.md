# TheDialogGame
---
TheDialogGame is a text-based adventure game developed as part of a first-year Java course. This project emphasizes object-oriented programming (OOP) principles and integrates design patterns to create a modular and extensible game experience.

In this game, players explore a dynamic map, unlock new zones by solving puzzles, collect and interact with items, and progress through a rich narrative-driven journey.

## Features

### Gameplay

	•	Explore the Map: Travel across interconnected zones, unlocking new areas as you solve puzzles and progress through the story.
	•	Interact with Objects: Pick up, inspect, drop, or use items to solve challenges and advance.
	•	Solve Puzzles: Engage with riddles and clues to unlock new zones and unravel mysteries.
	•	Commands-Based Interface: Type commands like go, take, inspect, or solve to interact with the game world.

### Technical Highlights

	•	Object-Oriented Design: Modular design using encapsulation, inheritance, and polymorphism.
	•	Design Patterns:
	•	Factory Pattern: For dynamically creating game objects (e.g., zones, puzzles, or items).
	•	Singleton Pattern: For managing the game state and player data.
	•	Strategy Pattern: For implementing different puzzle-solving mechanics.
	•	Text-Based Input System: Intuitive command system with clear feedback to guide the player.

---
## Example Gameplay

<img width="738" alt="gameplay-exemple" src="https://github.com/user-attachments/assets/654946ee-2139-4336-98be-ec37d31064b4">

---
## Available Commands

	Command >"Drop"  
	Description: Command used to remove items from your inventory.  
	When to use: When you want to remove an item from your inventory. It drops to the ground but does not disappear.  
	Variant: The `drop all` version removes all items from the inventory.  
	
	Command >"Help"  
	Description: The help command lists all available commands in the game along with their information.  
	When to use: When you don’t remember what to do or want to check the interactions available to you.  
	
	Command >"Take"  
	Description: Command used to pick up items that can be collected.  
	When to use: When you find an item that seems important, keep it! You never know, it might be useful later.  
	Variant: The `take all` command collects all retrievable items in a zone.  
	
	Command >"Read"  
	Description: Command to read letters you find.  
	When to use: Read this letter; it might contain important clues.  
	
	Command >"Solve"  
	Description: Use this command to solve puzzles.  
	When to use: When you want to submit an answer to a puzzle.  
	
	Command >"Go"  
	Description: This command moves the player across the map.  
	When to use: To travel, you have four movement options (North/South/East/West).  
	
	Command >"Inspect"  
	Description: Command used to inspect items.  
	When to use: Inspect items; they might contain valuable clues.  
	
	Command >"Quit"  
	Description: Exit the game.  
	When to use: To leave the game – Warning: no save functionality.  
	
	Command >"Inventory"  
	Description: This command displays the content of your inventory and the remaining space.  
	When to use: When you want to check what’s in your inventory.  
	
	Command >"Map"  
	Description: The map command displays the map. It highlights the player’s current position in green. Locked zones are shown in gray.  
	When to use: If you’re lost, it can help you orient yourself in the game.  
	
	Command >"Look"  
	Description: Command to observe and identify objects in the zone.  
	When to use: When you arrive in a new zone, use this command to get an overview of the objects around you.  
	They might hide important clues.  
	
	Command >"Open"  
	Description: Provided you have the correct keys in your inventory...  
	When to use: Use this command to open chests or locked zones on the map.  

---
## How to Run

	1.	Clone the repository, get the code:

	2.	Compile the Java files:

	3.	Run the game:

---
## Learnings

This project served as a practical application of OOP concepts and design patterns in a real-world scenario. It challenged us to think critically about game design, modularity, and scalability. I had a lot of fun coding this, the gameplay is not completly finished but all the infrastrucutre is there, feel free to clone and create your own gameplay.

---
## Feedback

If you have suggestions for improving the game mechanics, command system, or code structure, feel free to open an issue or submit a pull request!
