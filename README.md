# Etherlinker for UE4 #

### **[Getting started](https://bitbucket.org/kelheor/etherlinker-for-ue4/wiki/Getting%20started)** ###

### **[Frequently Asked Questions](https://bitbucket.org/kelheor/etherlinker-for-ue4/wiki/Frequently%20Asked%20Questions)** ###

### **[Tutorial videos](https://www.youtube.com/watch?v=uNWJeAJiQwg&list=PL_KX9infRdRiQjfQWTVG9kMvmKBsmUmUj)** ###

### **[UE4 Plugin API Reference](https://kelheor.bitbucket.io/Etherlinker/Etherlinker/)** ###

### **[Integration Server API Reference](https://kelheor.bitbucket.io/Etherlinker/Stratum/)** ###

### **[Downloads](https://drive.google.com/open?id=1OH30pWSP5c8Jthd1OEHdFf3BtfmN69D8)** ###

### **Features** ###

- Interact with Ethereum blockchain from Unreal Engine 4
- Compile new solidity contracts or integration server directly from UE4 Editor
- Start/Stop/Restart/Check integration server from UE4 Editor
- Contract deployment support
- ETH transfer support
- Wallet balance checking support
- Wallet creation support
- Custom solidity contracts support
- ERC20 token contract template with Premium Items and Subscriptions support
- ERC721 token contract template to make unique in-game entities, like pets
- Donations contract template - raise funds for your projects without paying commissions to third party providers.
- Lots of template widgets (compatible with VR and multiplayer) to speed up your development
- Lots of ways to create or load Ethereum wallets.
- Data encryption methods on both UE4 and integration server sides (SSL, AES-256, RSA, ECDSA, HMAC).
- External database support for integration server (Default is H2, recommended PostgreSQL)
- Integration server monitoring via Java Melody
- Multiplayer Support
- VR Support

### **Requirements** ###

**To start using Etherlinker for UE4, you need:**

- Unreal Engine 4.20 or above (Can be installed from Epic Games Launcher: https://www.epicgames.com/unrealtournament/download)
- JRE 8 (http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) - to run integration server, if you don't have JDK 8.
- Get access URL from Infura (https://infura.io/) to be able to interact with Ethereum blockchain from integration server.

**If you want to add custom contracts, change plugin's or server code:**

- Visual Studio 2017 (https://docs.unrealengine.com/en-us/Programming/Development/VisualStudioSetup)    
- JDK 8 (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - to compile integration server.  
- IntelliJ IDEA or similar IDE - to modify code of integration server.  
- Set JAVA_HOME variable to the JDK 8 location in order to run maven (just search for "how to set JAVA_HOME variable in Windows/Linux/Mac OS).  

**Additionally in production:**  

- Generate SSL certificate and put it here: **EtherlinkerServer\Stratum\src\main\resources**, then configure **application.properties** in the same directory. Or use existing certificate for debug purposes. - It will give you secure communication between UE4 application and integration server. Look FAQ for more details.  

### **How it works** ###

The project contains two parts:

- Integration server, written in Java, which interacts with Ethereum blockchain.
  
- UE4 Plugin, which sends requests to the integration server and getting responses from it.

Currently, integration server is using Infura to interact with Ethereum blockchain, but you can add your solution as well by modifying the code of integration server.

UE4 Plugin interacts with the integration server via JSON requests via HTTPS. You also can change this behavior by adapting the plugin's code to your own needs.

You can pack the integration server with your project so that it will be installed on the end-user machine. This way is preferred for small indie teams without a budget because it excludes costs for server maintenance.

You can also install the integration server on your dedicated server so that it could handle multiple projects.

It's also possible to install UE4 Plugin only on the server side to add additional security and scalability layer for complex multiplayer projects.

### **Security** ###

By default, all operations on the integration server generate signed transactions and send them to the infura network. It means that if you're using integration server locally on end-user PC, no credentials will be sent outside of integration server. In this case, you should distribute JRE with your project in order to run the integration server on end-user PC.  

If you have remote integration server, then you should securely transfer wallet credentials to it from end-user PC. You can use SSL encryption or add an additional custom encryption level over it. However, many users may not want to expose their wallet credentials in such a manner, so it's not the best approach. In this case, it's better to create and manage separate wallets on your server and give users the ability to sign in to their accounts in order to use their in-game wallets. If it's required, they can transfer funds from other wallets to in-game wallets by using external tools and use them in your project. Remote wallets will help you to achieve this.  

It's also possible to use both local and remote server in one application by specifying different server address for different purposes. For example, do all operations with funds on a local server, but execute some read-only contract methods on the server side.