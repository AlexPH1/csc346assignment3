# Using XStream

### Setting up XStream

#### Prerequisites: Installation of Maven and IntelliJ
		
Add the code below to your pom.xml file
		
	<dependency>
	<groupId>com.thoughtworks.xstream</groupId>
 	<artifactId>xstream</artifactId>
  	<version>1.4.19>/version>
	</dependency>

2. Upon doing so, refresh Maven using the
small on screen widget. 
This will add XStream to your project.

3. Now, you can call the XStream class and create
a new XStream object with
			
	> XStream xstream = new XStream();
			
4. While your dealing with XStream you'll be converting XML to Java objects.
You'll need to give xstream access to any classes you may be using. This 
would be done by the xstream method:
				
	xstream.allowTypeHierarchy(Some_Class.class);
				
5.In scenario's where you may wish to convert XML from or to an object,
it would be in your best interest to utilize xstream's alias method.
			
	xstream.alias("Some_XML_Element", some_Class.class)
			
This method tells xstream what class its given element is related to.
If I'm performing to or from XML without specifying the alias we
could run into problems. Xstream may determine an element to be
related to the completely wrong class. So, it's a good idea to 
explicitly tell xstream which elements are related to what.
			
### Dealing with a Simple XML File

1. Converting an object to XML
Let's say I have a class Business that
contains fields for a location and a name. I will
first create an object of this class.
			
	Business doughnuts = new Business("Saint Joseph", "Good Doughnuts");
		
Now I can convert this object into XML by using
			
	String objectToXML = xstream.toXML(doughnuts);
			
The XML equivalent of this doughnuts object
will look like this
			
	<doughnuts>
	<location>Saint Joseph</location>
	<name>Good Doughnuts</name>
	</doughnuts>
			
Pretty simple! But, what if I have an XML file
but want to use it to create an object of
a class; the opposite of what was just demonstrated.
			
2. In order to create an object from a XML file
first you must convert the XML file

	xstream.fromXML(objectToXML);

However we want this to go into an object
of a class in this case let's recreate the
doughnuts object from XML.
So now we'd be looking at:
			
	Business doughnutsMadeFromXML = 
	(Business)xstream.fromXML(objectToXML);
				
### Dealing with a nested XML File

1.Dealing with a nested XML file is very similar to dealing with a simple XML file.
The one thing necessary is to utilize another one of xstream's built in methods:
			
	xstream.ignoreUnknownElements();

Just as specified, xstream will skip over any XML that does not relate to the aliased class.
All other steps remain exactly the same!

### Dealing with an Arraylist within an XML File

1.To deal with an arraylist within an XML file we will use two classes. One class will
be used as a template for holding data captured from the XML file, identically
to how we did so when we were just worried about a simple XML file. The second
class will hold an arraylist of the first class. Now that our classes are sorted
we must alias BOTH classes. Within the XML file we'd be looking at something like this:

	<ArrayList_of_Some_Class>
	<Some_Class>
	<field1></field1>
	<field2></field2>
	.....
	</Some_Class>
	<Some_Class>
	<field1></field1>
	<field2></field2>
	.....
	</Some_Class>
	<Some_Class>
	<field1></field1>
	<field2></field2>
	.....
	</Some_Class>
	......
	</ArrayList_of_Some_Class>

Xstream will sort through the ArrayList_of_Some_Class element and collect Some_Class. However,
xstream will not realize that by collecting the elements for the arraylist, it is also collecting
the elements for Some_Class. To make xstream aware of what's going on we use this method:

	xstream.addImplicitCollection(ArrayList_of_Some_Class.class, "Some_Class", Some_Class.class);

This method is saying, within ArrayList_of_Some_Class.class there are Some_Class elements that belong to Some_Class.class
				
And that's how you use XStream!
			
