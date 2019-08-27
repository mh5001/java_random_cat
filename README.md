# Java Random Cat
An JFX project that display random cat images.

# How does it work?
I send an HTTP request to a [cat API](http://aws.random.cat/meow), which returns an image URL. I then stream the binary of said URL to a cache folder and display it using the JFX built in image displayer.

# Image
![image](https://gyazo.com/53d8eba192feb0903ac8b53d83571c82.png)
