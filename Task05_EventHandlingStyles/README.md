# Task 5 – Event-Handling Styles

## 1. Introduction

Java supports different approaches to handling GUI events. This currency converter demonstrates four ActionListener implementation styles.

## 2. Four Event-Handling Approaches

1. **ActionListener:** Implements the ActionListener interface and overrides actionPerformed().
2. **Named Inner Class:** Uses a separate inner class to implement ActionListener.
3. **Anonymous Inner Class:** Creates an unnamed listener object directly inside addActionListener().
4. **Lambda Expression:** Uses a shorter functional programming syntax to handle events.

## 3. Comparison

| Approach | Advantages | Limitations |
|---|---|---|
| ActionListener | Clear and standard approach | Requires more code |
| Named Inner Class | Reusable and organized | Requires a separate class |
| Anonymous Inner Class | Suitable for one-time events | More verbose |
| Lambda Expression | Short and readable | Best suited to functional interfaces |

## 4. Enter Key Support

An ActionListener is attached to the text field. When the user presses Enter, the conversion method is executed.

## 5. Dialog Box

JOptionPane displays the converted amount or an error message. It provides clear feedback without requiring another window.

## 6. Conclusion

All four approaches can handle button-click events effectively. Lambda expressions reduce code length, while named inner classes are useful when listener logic needs to be reused.