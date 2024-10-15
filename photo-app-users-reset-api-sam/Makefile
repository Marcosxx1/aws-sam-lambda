# Makefile for running and debugging AWS Lambda functions locally with SAM

# Run target
.PHONY: run
run:
	sam local invoke PostHandlerLambdaFunction --event events/event.json

# Run with Debug target
.PHONY: run-debug
run-debug:
	sam local invoke PostHandlerLambdaFunction --event events/event.json -d 5858
