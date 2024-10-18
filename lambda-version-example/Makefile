# Makefile for AWS SAM project with targets for building, deploying, running, and debugging

# Define all phony targets to avoid conflicts with files named the same
.PHONY: run run-debug sam-deploy-guided sam-build sam-log sam-delete

# Run the Lambda function locally using SAM with the specified event file
run:
	sam local invoke LambdaVersionExampleFunction --event events/event.json

# Run the Lambda function locally with debugging enabled on port 5858
run-debug:
	sam local invoke LambdaVersionExampleFunction --event events/event.json -d 5858

# Build the SAM application (compiles code and prepares deployment artifacts)
sam-build:
	sam build

# Deploy the SAM application interactively (prompts for parameters)
sam-deploy-guided:
	sam deploy --guided

# Deploy the SAM application
sam-deploy:
	sam deploy

# View the logs of the deployed Lambda function by stack name
sam-log:
	sam logs --name LambdaVersionExampleFunction --stack-name lambda-version-exampl

# Delete the SAM application stack (removes all AWS resources created)
sam-delete:
	sam delete --stack-name lambda-version-exampl
