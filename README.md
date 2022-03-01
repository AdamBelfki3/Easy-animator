# Easy Animator

A **GUI** animator capable of **rendering animations** and **visualizing algorithms** based on given input files. The animator implements all features included in a typical video player, in addition to features like **slow motion** and **discrete-time**. This project was programmed using **Java**, **Java Swing**, and **MVC Design Patterns**. Additionally, this project was completed in a collaborative, pair programming effort with **Mirana Anwar**.

<img src="https://media.giphy.com/media/GYB2xir5X6aCB3Iv7g/giphy.gif" height=350>

## Features
The Easy Animator offers multiple ways to render or view a certain animation. Here is all the **supported views** and the features they present:
* **text**: Generates a textual representation of an animation as a sequence of timed steps, covering the creation of shapes and theirs motions, which would depicts a change in the coordinate values of each shape at each instant.

* **visual**: Basic visual rendering of an animation on a **GUI** without any control capabilities.

* **svg**: Generates an **svg** formatted output of a visualization.

* **interactive**: Visually and interactively renders an animation displayed on **GUI** window, with added capabilities like **Pause**, **Resume**, **Speed up (x2)**, **Slow down (x0.5)**, **Restart**, and **Loop**.

* **interactive plus**: Most complete animator, such that it extends the **interactive** view to implement additional features like **Discrete-time** and the **Outline** functionality on the shapes.

The **shapes** currently supported by the animator are: **Rectangle**, **Ellipse**, and **Plus sign**. Nevertheless, this implementation can be easily extended to support additional shapes at the user's need.


## Usage

Download the jar file `Easy-animator.jar` sitting at the root of this project. From there, assuming `java` is installed, you can run your animation using the excellence class

 ```
java -jar Easy-animator.jar -in <input-file> -view <view>
 ```

 ##### Arguments:
 * **reqiured**
    * `-in`: input file containing instructions to render the animation.
    * `-view`: indicates the view that should be used to render the animation. Choose from the **valid views** detailed above.

 * **optional**
    * `-out`: path to create the output file containing steps to render a simulation.
    * `-speed`: starting speed used in rendering the animation, defautlts to **1**.

#### Input Files
Input files are used to provide the animator instructions about how the animation is generated. They are stored as a `.txt` extension, and they allow you to provide your own animation for rendering. Input files must follow a certain format to achieve the desired implementation:

1. Specify the animation's **window size**: `canvas <x1> <y1> <x2> <y2>`.
2. **Adding a shape** to the animation: `shape <name> <shape>`.
3. Giving a **motion** to the shape: `motion <shape_name> <t1> <x1> <y1> <height1> <width1> <r1> <g1> <b1> <t2> <x2> <y2> <height2> <width2> <r2> <g2> <b2>`


#### Selection Sort
You visualize the steps of the **Selection Sort** algorithm by generating its corresponding input files using the following command:

 ```
 java -cp Easy-animator.jar cs3500.animations.selectionsortalgorithm.SelectionSort -out ./resources/selection-sort.txt -length <length>
 ```

 ##### Arguments:

 * **reqiured**
    * `-out`: path to create the output file containing steps to render a simulation.
    * `-length`: number of elements to be sorted.
