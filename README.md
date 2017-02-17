# VertexOfPolylineGetter
From AutoCad to AnyLogic programm.

Using this project you can create railroad scheme in AutoCad
and then use it in AnyLogic as railway network.

### Result example: 
AutoCad railroad scheme: <br />
![alt tag](https://cloud.githubusercontent.com/assets/20573448/23059831/24b02a1c-f50c-11e6-9a9e-e2ad6c48f0bd.jpg)
AnyLogic railway network: <br />
![alt tag](https://cloud.githubusercontent.com/assets/20573448/23059725/b929afde-f50b-11e6-8ce3-103956f4ec3e.jpg)

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
