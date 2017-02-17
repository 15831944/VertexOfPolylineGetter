# VertexOfPolylineGetter
From AutoCad to AnyLogic programm.

Using this project you can create railroad scheme in AutoCad
and then use it in AnyLogic as railway network.

### Result example:


### Usage: <br />
1. VertexOfPolylineGetter (C#)
	- create AutoCad file (.dwg)
	- create railroad scheme (tracks - polylines, switches - points)
	- load "VertexOfPolylineGetter.dll" (VertexOfPolylineGetter\VertexOfPolylineGetter\bin\Debug)
	- execute GETPOLYLINEVERTEX command
		this command scans objects in your model space 
		and write information about polylines(dot coordinates) and points(coordinates)
		in file "polylineInformation.txt" (VertexOfPolylineGetter\VertexOfPolylineGetter\bin\Debug)
2. JaxbTest (Java)
	- copy "polylineInformation.txt" in VertexOfPolylineGetter\JaxbTest
	- execute ALPGenerator and get "forAnyAlp.txt" (VertexOfPolylineGetter\JaxbTest)
	- in this file you find railway network in AnyLogic view - xml structure
	- copy paste this structure from root "Shapes" to AnyLogic .alp file (after "AgentLinks" element)
3. AnyLogic
	- execute AnyLogic .alp file and use your scheme in it.	
