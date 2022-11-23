# nqry-coding-challenge
The aim of this coding challenge is to design and implement a simple point-of-sale (POS) solution for a client who owns a cafe. Specifically, the domain model. The POS solution should take in 3 or more selections and calculate the final cost. These selections include:

- Coffee Blend
- Preparation style
- Size
- Optional condiments

The design should be flexible to add new coffee types, preparation methods, sizes, and additional condiments. There should be some form of quality control. And reasons for the choice of design should be provided.

# Proposed Solution
The proposed solution uses the composite Structural Design pattern which lets you compose objects into tree structures and then work with these structures as if they were individual objects.

The coffee order is a container which is composed of leaves (the selections). The container(s) and leaves share a common interface (IChargeable) which declares a method for accounting the price. This may be a simple addition, or a function of the current tallied cost (as with the size selection).

To determine the cost of a coffee order, one simply needs to call the common interface method on all of coffee order's selections.

The leaves will be enum classes which implement the common interface. This is because the selections are constants (e.g. the selection and its price). And the coffee order will be class which implements the common interface.

# How to Build
This project is built using gradle. Refer to the following for gradle installation:
https://docs.gradle.org/current/userguide/installation.html

and how to build:
https://docs.gradle.org/current/samples/sample_building_java_applications.html
