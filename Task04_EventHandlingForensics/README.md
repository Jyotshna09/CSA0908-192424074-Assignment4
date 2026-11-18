# Task 4 – Event-Handling Forensics

## 1. Problem Diagnosis

The original DrawPad program may fail because mouse events are not handled correctly and the drawing is performed directly without maintaining its state.

## 2. Corrected Program

The corrected DrawPad uses MouseAdapter to detect mouse clicks. Each click position is stored in an ArrayList of Point objects. The repaint() method requests the component to be redrawn.

## 3. Importance of repaint()

The repaint() method schedules a new painting operation. It ensures that the drawing is refreshed when the window is resized, minimized, or restored.

## 4. TODO Explanations

**TODO 1 – Mouse Event Handling:** A MouseAdapter is registered using addMouseListener(). The mousePressed() method captures the clicked position.

**TODO 2 – Drawing:** The paintComponent() method uses Graphics to draw blue circles at the stored positions.

## 5. Importance of @Override

The @Override annotation indicates that a method overrides a method inherited from its parent class. It helps the compiler identify incorrect method signatures.

## 6. BufferedImage Alternative

BufferedImage can be used as an off-screen drawing surface. Drawing operations are stored in the image and displayed through Graphics. This approach is useful for more advanced drawing applications because it maintains a separate image representation.

## 7. Conclusion

The corrected program demonstrates mouse event handling, event listeners, repainting, and custom painting in Java Swing. Storing drawing points ensures that the content remains visible during repaint operations.