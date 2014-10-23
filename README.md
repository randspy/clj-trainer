# clj-trainer

Program I am going to use during my training sessions. 
It is going to notify me about the next exercise with google translate voice
(requires internet connection).

## Usage

To run this application you need to execute

    lein deps
    lein uberjar
    java -jar target/clj-trainer-0.1.0-SNAPSHOT-standalone.jar file_with_training_plan.txt
    
## Example file

    text - push ups
    timer - 5
    text - more push ups
    timer - 3

Where time is in seconds.