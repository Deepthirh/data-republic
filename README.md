# data-republic
Data Republic Test Assessment

### Question 1:
#### The tests are configured to run in Chrome and Firefox browsers on two platforms Mac and Windows

A chrome driver and firefox gecko driver for mac and windows platforms are present under `src/test/resources/driver` folder

### Prerequisites :
JDK 1.8 , Maven 3.0 

#### This is a maven project
To run this test, please make sure maven is present on an appropriate system and `mvn` is added to system's path

Command to run the test:

```mvn clean install```

## Test HTML Report
A test report is generated after the tests are run and is present under the following location

```target/cucumber-html-reports```


### Question 2:

AWS Work Sheet:
Note : the following commands are executed using AWS CLI 
Prerequisites: AWS and AWS CLI modules
```aws configure```  command should be used to configure the CLI by giving the AWS Access Key ID, AWS Secret Access Key,Default region name and output format


Launch an EC2 `t2.micro` instance using existing subnet, security group and key pair
```
aws ec2 run-instances --image-id ami-47c21a25 --subnet-id <reference to an existing subnet id> --security-group-ids <reference to an existing security-group ids> --count 1 --instance-type t2.micro --key-name <reference to an existing key-pair name> --query 'Instances[0].InstanceId'
```

For example : when the correct subnet id , security group and key pair name is given and the above command is run it givs us the ec2 instance id which is created like : i-00eaf649823084c42

Describe an instance
```
aws ec2 describe-instances --instance-ids <a list of instance ids>
```
The above command gives the json describing the instace dtails

Show instance's state
```
aws ec2 describe-instances --instance-ids <a list of instance ids> --query 'Reservations[0].Instances[0].State.Name'
```
If the ec2 instance is created successfully, it shows the state as "running"


Terminate an instance and check it's state
```
aws ec2 terminate-instances --instance-ids <a list of instance ids>
aws ec2 describe-instances --instance-ids <a list of instance ids> --query 'Reservations[0].Instances[0].State.Name'
```
Terminates the EC2 instance
