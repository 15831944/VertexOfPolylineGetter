using System;
using System.Reflection;
using System.Text;
using Autodesk.AutoCAD.DatabaseServices;
using Autodesk.AutoCAD.Geometry;
using VertexOfPolylineGetter.xmlPackadge;

namespace VertexOfPolylineGetter
{
    /// <summary>
    /// get information of AutoCad objects and make railway network
    /// </summary>
    public class NetworkMaker
    {
        private static int _numberForTrackId = 0;
        private static int _numberForTrackName = 0;
        private static int _numberForYardId = 0;
        private static int _numberForYardName = 0;
        private static int _numberForSwitchId = 0;
        private static int _numberForSwitchName = 0;

        // for tracks and switches names
        private static int _counterForTracks = 0;
        private static int _counterForSwitches = 0;

        private const string XmlFileName = "RailwayNetwork.xml"; // xml file for write information about tracks

        private BlockTableRecord _blockTableRecord;

        public NetworkMaker(BlockTableRecord blockTableRecord)
        {
            _blockTableRecord = blockTableRecord;
        }

        public Shapes MakeShapes()
        {
            XmlProvider provider = new XmlProvider(XmlFileName);

            Shapes mainShapes = new Shapes();
            Railyard railyard = MakeRailyard(); // till work with one railYard
            Shapes shapes = new Shapes(); // shapes in railYard

            //shapes.RailTracksList = makeListOfTracks();
            //shapes.RailroadSwitchesList = makeListOfSwitches();
            
            railyard.Shapes = shapes;

            mainShapes.RailyardsList.Add(railyard); // have in a view that only one railyard will be in mainShapes

            //foreach (ObjectId acObjId in _blockTableRecord)
            //{
            //    // can use it in debug
            //    //acDoc.Editor.WriteMessage("\n" + acObjId.ObjectClass.Name + " - " + acObjId + " - " + acObjId.ObjectClass.DxfName);

            //    switch (acObjId.ObjectClass.DxfName) // see object type
            //    {
            //        // work with PolyLines
            //        case "LWPOLYLINE":
            //            {
            //                DBObject dbObject = acObjId.GetObject(OpenMode.ForRead);
            //                Polyline pln = dbObject as Polyline;
            //                int vn = pln.NumberOfVertices;
            //                StringBuilder stringForWriteInFile = new StringBuilder($"track{++_counterForTracks}: ");
            //                for (int i = 0; i < vn; i++)
            //                {
            //                    // Could also get the 3D point here
            //                    Point2d pt = pln.GetPoint2dAt(i);
            //                    acDoc.Editor.WriteMessage("\n" + pt.X + " - " + pt.Y);
            //                    stringForWriteInFile.Append($"{pt.X:0.00} {pt.Y:0.00} ");
            //                }
            //                file.WriteLine(stringForWriteInFile.ToString()); // write information about next polyline
            //                break;
            //            }

            //        // work with dots
            //        case "POINT":
            //            {
            //                DBObject dbObject = acObjId.GetObject(OpenMode.ForRead);
            //                // use reflextion to get point
            //                PropertyInfo positionProperty = dbObject.GetType().GetProperty("Position");
            //                Point3d point3d = (Point3d)positionProperty.GetValue(dbObject);
            //                // write information in file
            //                string stringForWriteInFile = $"switch{++_counterForSwitches}: {point3d.X:0.00} {point3d.Y:0.00}";
            //                acDoc.Editor.WriteMessage("\n" + point3d.X + " - " + point3d.Y);
            //                file.WriteLine(stringForWriteInFile);
            //                break;
            //            }
            //    }
            //    nCnt = nCnt + 1;
            //}


            return null;
        }

        private Railyard MakeRailyard()
        {
            return new Railyard(MakeYardId(), MakeYardName(), Constants.FirstX, Constants.FirstY);
        }

        // проверить эту строку
        private string MakeYardId()
        {
            _numberForYardId++;
            return $"1486646288{_numberForSwitchId:000d}";
        }

        private string MakeYardName()
        {
            _numberForYardName++;
            return $"1486646288{_numberForYardName:000d}";
        }
    }

    //Shapes shapes = new Shapes();
                //Shapes railYardShapes = new Shapes();

                //Railyard railyard = new Railyard();
                //railyard.Id = "111111111111";

                //RailTrack railTrack = new RailTrack();
                //RailTrack railTrack1 = new RailTrack();
                //railTrack.Id = "222222222222";
                //railTrack1.Id = "333333333333";
                //List<RailTrack> railTracks = new List<RailTrack>();
                //railTracks.Add(railTrack);
                //railTracks.Add(railTrack1);
                //List<Railyard> railyards = new List<Railyard>();
                //railyards.Add(railyard);
                //shapes.RailyardsList = railyards;
                //railYardShapes.RailTracksList = railTracks;

                //railyard.Shapes = railYardShapes;

                //XmlProvider provider = new XmlProvider(XmlFileName);
                //provider.SaveShapes(shapes);

                //acDoc.Editor.WriteMessage("done!");


                //Railyard railyard = new Railyard();

                //System.IO.StreamWriter file = new System.IO.StreamWriter(FileName);
                //file.WriteLine("Begin:");

                ////Step through each object in Model space and
                ////display the type of object found
                //// WriteMessage plays roles of log messages
                //foreach (ObjectId acObjId in acBlkTblRec)
                //{
                //    acDoc.Editor.WriteMessage("\n" + acObjId.ObjectClass.Name + " - " + acObjId + " - " + acObjId.ObjectClass.DxfName);

                //    switch (acObjId.ObjectClass.DxfName) // see object type
                //    {
                //        // work with PolyLines
                //        case "LWPOLYLINE":
                //            {
                //                DBObject dbObject = acObjId.GetObject(OpenMode.ForRead);
                //                Polyline pln = dbObject as Polyline;
                //                int vn = pln.NumberOfVertices;
                //                StringBuilder stringForWriteInFile = new StringBuilder($"track{++_counterForTracks}: ");
                //                for (int i = 0; i < vn; i++)
                //                {
                //                    // Could also get the 3D point here
                //                    Point2d pt = pln.GetPoint2dAt(i);
                //                    acDoc.Editor.WriteMessage("\n" + pt.X + " - " + pt.Y);
                //                    stringForWriteInFile.Append($"{pt.X:0.00} {pt.Y:0.00} ");
                //                }
                //                file.WriteLine(stringForWriteInFile.ToString()); // write information about next polyline
                //                break;
                //            }

                //        // work with dots
                //        case "POINT":
                //            {
                //                DBObject dbObject = acObjId.GetObject(OpenMode.ForRead);
                //                // use reflextion to get point
                //                PropertyInfo positionProperty = dbObject.GetType().GetProperty("Position");
                //                Point3d point3d = (Point3d)positionProperty.GetValue(dbObject);
                //                // write information in file
                //                string stringForWriteInFile = $"switch{++_counterForSwitches}: {point3d.X:0.00} {point3d.Y:0.00}";
                //                acDoc.Editor.WriteMessage("\n" + point3d.X + " - " + point3d.Y);
                //                file.WriteLine(stringForWriteInFile);
                //                break;
                //            }
                //    }
                //    nCnt = nCnt + 1;
                //}
                //file.WriteLine("End.");
                //file.Close();

                //// If no objects are found then display a message
                //if (nCnt == 0)
                //{
                //    acDoc.Editor.WriteMessage("\n  No objects found");
                //}
}