# Newton's Laws Implementation

## Info

-   Author: Michael Slain
-   Acknowledgements: Mr. Kuszmaul

## Outline

-   Matter

    -   _constructor_
        -   **input:** _none_
        -   **output:** _none_
        -   **effect:** _none_
    -   _constructor_
        -   **input:** position as as number
        -   **output:** _none_
        -   **effect:** sets the intial position of the instance to the position value that is provided
    -   getEmotionalStatus
        -   **input:** _none_
        -   **output:** emotional status as a boolean
        -   **effect:** returns the emotional status of the instance
    -   getPosition
        -   **input:** _none_
        -   **output:** position
        -   **effect:** returns the position of the instance
    -   getVelocity
        -   **input:** _none_
        -   **output:** velocity
        -   **effect:** returns the velocity of the instance
    -   getAcceleration
        -   **input:** _none_
        -   **output:** acceleration
        -   **effect:** returns the acceleration of the instance
    -   getForce
        -   **input:** _none_
        -   **output:** force
        -   **effect:** returns the force of the instance
    -   getMass
        -   **input:** _none_
        -   **output:** mass
        -   **effect:** returns the mass of the instance
    -   setForce
        -   **input:** a boolean representing the new force
        -   **output:** _none_
        -   **effect:** changes the force of the instance to the one provided
    -   updatePosition
        -   **input:** delta time
        -   **output:** _none_
        -   **effect:** Updates position of the instance based on velocity
    -   updateVelocity and delta time
        -   **input:** delta time
        -   **output:** _none_
        -   **effect:** Updates velocity of the instance based on acceleration and delta time
    -   updateVelocityHalfWay
        -   **input:** _none_
        -   **output:** _none_
        -   **effect:** Updates the velocity of the instance based on acceleration, but divided by 2
    -   updateAcceleration
        -   **input:** _none_
        -   **output:** _none_
        -   **effect:** Updates acceleration of the instance based on force and mass
    -   updateEmotionalStatus
        -   **input:** _none_
        -   **output:** _none_
        -   **effect:** Changes emotional status of the instance when position passes a certain threshold
    -   update
        -   **input:** delta time
        -   **output:** _none_
        -   **effect:** updates acceleration, velocity, position, and emotional status, as well as prints data of the instance
    -   newUpdate
        -   **input:** delta time
        -   **output:** _none_
        -   **effect:** updates acceleraiton, velocity, postiion, and emotional status, as well as prints dat aof the instance. The difference between this and `update` is that one uses `updateVelocity` and this one uses `updateVelocityHalfWay` twice
    -   toString
        -   **input:** _none_
        -   **output:** string representation
        -   **effect:** returns a string representaiotn of the instance

## Dev

-   Run tests

```zsh
java Main.java
```
