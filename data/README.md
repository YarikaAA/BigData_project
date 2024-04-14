# Food Delivery Dataset

The Food Delivery Dataset is designed for predicting the time taken by delivery personnel to deliver food from the restaurant to the delivery location. This prediction is based on several factors including the age of the delivery person, their previous ratings, the distance between the restaurant and the delivery location, among others.

## Dataset Overview

- **Entries**: 45,593
- **Columns**: 11

## Columns Description

- **ID**: A unique identifier for each delivery instance.
- **Delivery_person_ID**: A unique identifier for the delivery person.
- **Delivery_person_Age**: The age of the delivery person, ranging from 15 to 50 years.
- **Delivery_person_Ratings**: The rating of the delivery person, on a scale from 1.0 to 6.0.
- **Restaurant_latitude**: The latitude of the restaurant's location.
- **Restaurant_longitude**: The longitude of the restaurant's location.
- **Delivery_location_latitude**: The latitude of the delivery location.
- **Delivery_location_longitude**: The longitude of the delivery location.
- **Type_of_order**: The type of order, such as 'Snack', 'Drinks', 'Buffet', etc.
- **Type_of_vehicle**: The type of vehicle used for delivery, e.g., 'motorcycle', 'scooter'.
- **Time_taken(min)**: The time taken for the delivery in minutes, which is the target variable for prediction.

## Statistical Summary

- **Delivery_person_Age**: The average age is approximately 29.54 years with a standard deviation of 5.70.
- **Delivery_person_Ratings**: Average rating is 4.63 with a standard deviation of 0.33.
- **Time_taken(min)**: Delivery times range from 10 to 54 minutes, with an average delivery time of about 26.29 minutes.

## Usage

This dataset can be utilized to build machine learning models to predict delivery times based on various features provided. The target variable for prediction is `Time_taken(min)`.

## Note

- The dataset includes both numerical and categorical data.
- Location data (latitude and longitude) are provided for both restaurants and delivery locations, allowing for distance calculations that could be used as a feature in predictive modeling.
