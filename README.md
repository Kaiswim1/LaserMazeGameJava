The Laser Maze Game: 

Why I created it: I made this project for a few reasons. One of my students gave me the idea for this project. Not only was this a really fun challenge, it highlights a small piece of most of my skills and understanding. I was not aiming for a large project with hundreds of features but rather a project that is easy to understand, easy to look through the code, and contains small chunks of really core concepts. 

My goal was to make a basic Laser Maze Example in the best code formatting that I could. Every line of code and architecture design decision has conciseness and readability in mind. The idea was to make this easy for any employer or recruiter to look at and say “this is a really well designed program and I would love to work on a project with this developer”. The idea of this project is to act as a portfolio piece that is easily digestible.  

Any code reviews, questions, and comments would be greatly appreciated. 

The concepts highlighted in the project:  

This project incorporates the following concepts. 
Object-Oriented Design: OOP in this project is used primarily for abstraction and clarity rather than reuse. For example, the Graphics class extends JFrame to handle rendering, and the Controls class extends MouseListener to manage user input. These inheritance relationships help clearly define the roles and responsibilities of each class, improving readability and organization without overcomplicating reuse.


Data Structures: A HashMap is used to efficiently track objects like mirrors, and I implemented custom equals and hashCode methods to ensure that mirror objects are treated as duplicates when they share the same (x, y) position, even if other fields (like rotation) differ. I considered using Java's record type for this, but chose a traditional class because the mirror’s rotation is mutable, and records are inherently immutable.


Algorithmic Thinking: The core laser algorithm simulates a directional beam moving through a grid. It works by using an (x, y) pointer that hops one full grid space at a time, like a rabbit, based on its current rotation. When the laser reaches a mirror, the angle of rotation is updated using trigonometric logic, changing the direction of its next hops. After each hop, a “line” is drawn — implemented as a sequence of adjacent squares placed in the direction of the previous movement, forming a continuous beam with no gaps. This approach elegantly simulates laser reflection and demonstrates the ability to break down a physics-like system into precise, manageable steps.


Reflection and Annotations: I created custom runtime annotations combined with reflection to enforce that certain classes (such as the rendering or control classes) include specific parameters in their methods. Like forcibly requiring a Graphics parameter for rendering and a MouseEvent parameter for event-handling. This demonstrates not just architectural awareness but also the ability to write self-validating, scalable code.


Unit Testing for Complex Logic: I included unit tests specifically around the multi-step logic to ensure it performs correctly under various conditions. While I don’t believe every line of code needs a unit test, complex processes absolutely should be tested, and this project reflects that principle.


UI Concepts: Basic UI interactions are included to show an understanding of MouseEvent handling and rendering via java.awt.Graphics, giving the project an interactive, visual layer.


Clean Code Practices: All functions are concise, purposeful, and adhere to the single-responsibility principle. Indentation is minimal and deliberate to emphasize simplicity and maintainability.


Thoughtful Code Comments: Comments are included only where needed — not to explain what the code does, but to clarify why decisions were made. These annotations help make the codebase more understandable for other developers (or for future maintenance).


Design Principles: The project is guided by modern, maintainable software design principles. From enforcing contracts via annotations, to minimizing class responsibilities, the code remains modular, testable, and easy to expand. 

Packaging, Deployment, and GitHub Distribution: This project is packaged as a downloadable JAR file and hosted via GitHub Pages — completely free for both users and myself. The full Java source code is available on GitHub.
I welcome contributions from new developers. Possible feature ideas include:
Add a menu to:
Choose mirror count
Customize grid size


Implement a level system
Create a mode where the laser must hit 3 specific targets to win


Add multiplayer using:
Express.js (LAN server, learn about octet parsing & hosting/joining)




Learn more: 
//My technical resume and story.  


What I'm Looking for: 
I'm looking to gain hands-on experience developing and deploying software as part of a professional team — ideally one where I can learn from experienced engineers that know more than I do.
For the past three years, I’ve been teaching computer programming, and now I’m excited to step back into a learning role. I’m eager to deepen my practical understanding of modern software development practices and refine my skills within a collaborative environment.
My goals are to:
Better understand the dynamics of working on a professional development team. 


Strengthen my experience with the Java tech stack, especially:


Spring Boot (my experience writing custom annotations has given me valuable insight into how Spring works under the hood)


PostgreSQL


Maven, and related tooling


While I’ve already worked with these technologies independently, I believe that working with the right team will elevate my skills and prepare me for long-term success in the industry.

