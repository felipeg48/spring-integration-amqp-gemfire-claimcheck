AMQP Backed Spring Integration using vFabric RabbitMQ 
=====================================================

In this project, I will demo Spring Integration, vFabric RabbitMQ and Gemfire to demo Claimcheck pattern. 

To quickly see how it works,

* Get the latest code
* Run "mvn test" to see all the tests work. 

If you want to do End to End testing follow the steps below.
* Install [ERLang](http://www.erlang.org/download/otp_win32_R15B02.exe)

	Set ERLANG_HOME=[ERLang install location]

* Install [RabbitMQ](http://www.rabbitmq.com/releases/rabbitmq-server/v2.8.7/rabbitmq-server-2.8.7.exe) 
* Open RabbitMQ Command Prompt from the start menu and run below commands

	rabbitmq-plugins enable rabbitmq_management

	rabbitmq-server.bat

* Open http://localhost:55672/mgmt/ and login as guest/guest, just to check RabbitMQ is running
* Maven imported spring-integration-amqp-gemfire-claimcheck project into STS IDE 
* Add spring-integration-amqp-gemfire-claimcheck on the server and start the TC server and "Run on Server", you will notice that the Application Subscribed to RabbitMQ. And by default it created 2 queues: si.fanout.pub-sub-channel, p2p-pollable-channel
* To demo the Pub/sub model, put a message on to the p2p-pollable-channel, the SI flow gets triggered of

Refer this [blog](http://krishnasblog.com/) for more details on the above flow.

Feel free to modify this code and use it for your need. 
