using System.Reflection;
using System.Text;
using Autodesk.AutoCAD.Runtime;
using Autodesk.AutoCAD.ApplicationServices;
using Autodesk.AutoCAD.DatabaseServices;
using Autodesk.AutoCAD.Geometry;

[assembly: CommandClass(typeof(VertexOfPolylineGetter.Class1))]

namespace VertexOfPolylineGetter
{
    public class Class1
    {
        private static int counterForTracks = 0;
        private static int counterForSwitches = 0;

        /// <summary>
        /// Command get information about polylines(vertexies) and points(coordinates) of ModelSpace
        /// </summary>
        [CommandMethod("GetPolylineVertex")]
        public static void GetPolylineVertex()
        {
            // Get the current document and database, and start a transaction
            Document acDoc = Application.DocumentManager.MdiActiveDocument;
            Database acCurDb = acDoc.Database;

            using (Transaction acTrans = acCurDb.TransactionManager.StartTransaction())
            {
                // Open the Block table record for read
                BlockTable acBlkTbl;
                acBlkTbl = acTrans.GetObject(acCurDb.BlockTableId,
                                             OpenMode.ForRead) as BlockTable;

                // Open the Block table record Model space for read
                BlockTableRecord acBlkTblRec;
                acBlkTblRec = acTrans.GetObject(acBlkTbl[BlockTableRecord.ModelSpace],
                                                OpenMode.ForRead) as BlockTableRecord;

                int nCnt = 0; // find objects counter
                acDoc.Editor.WriteMessage("\n--------------------------------------------------------------------------------------------");
                acDoc.Editor.WriteMessage("\nHi! I'm command getPolylineVertex.");
                acDoc.Editor.WriteMessage("\nI'll scan this model space and find all objects.");
                acDoc.Editor.WriteMessage("\nIf find object is Polyline I'll get it vertexies and write their coordinates in file.");
                acDoc.Editor.WriteMessage("\nYou can find this file in dll's directory.");
                acDoc.Editor.WriteMessage("\ngetPolylineVertex start working...");
                acDoc.Editor.WriteMessage("\nModel space objects: ");

                System.IO.StreamWriter file = new System.IO.StreamWriter("polylineInformation.txt"); // file for write information about polylines
                file.WriteLine("Begin:");
                // Step through each object in Model space and
                // display the type of object found
                foreach (ObjectId acObjId in acBlkTblRec)
                {
                    acDoc.Editor.WriteMessage("\n" + acObjId.ObjectClass.Name + " - " + acObjId + " - " + acObjId.ObjectClass.DxfName);

                    switch (acObjId.ObjectClass.DxfName)
                    {
                        // work with PolyLines
                        case "LWPOLYLINE":
                        {
                            DBObject dbObject = acObjId.GetObject(OpenMode.ForRead);
                            Polyline pln = dbObject as Polyline;
                            int vn = pln.NumberOfVertices;
                            StringBuilder stringForWriteInFile = new StringBuilder($"track{++counterForTracks}: ");
                            for (int i = 0; i < vn; i++)
                            {
                                // Could also get the 3D point here
                                Point2d pt = pln.GetPoint2dAt(i);
                                acDoc.Editor.WriteMessage("\n" + pt.X + " - " + pt.Y);
                                stringForWriteInFile.Append($"{pt.X:0.00} {pt.Y:0.00} ");
                            }
                            file.WriteLine(stringForWriteInFile.ToString()); // write information about next polyline
                            break;
                        }

                        // work with dots
                        case "POINT":
                        {
                            DBObject dbObject = acObjId.GetObject(OpenMode.ForRead);
                            // use reflextion to get point
                            PropertyInfo positionProperty = dbObject.GetType().GetProperty("Position");
                            Point3d point3d = (Point3d) positionProperty.GetValue(dbObject);
                            // write information in file
                            string stringForWriteInFile = $"switch{++counterForSwitches}: {point3d.X:0.00} {point3d.Y:0.00}";
                            acDoc.Editor.WriteMessage("\n" + point3d.X + " - " + point3d.Y);
                            file.WriteLine(stringForWriteInFile);
                            break;
                        }
                    }
                    nCnt = nCnt + 1;
                }
                file.WriteLine("End.");
                file.Close();

                // If no objects are found then display a message
                if (nCnt == 0)
                {
                    acDoc.Editor.WriteMessage("\n  No objects found");
                }

                // Dispose of the transaction
                acDoc.Editor.WriteMessage("\ngetPolylineVertex done!");
                acDoc.Editor.WriteMessage("\n--------------------------------------------------------------------------------------------");
            }
        }
    }
}
