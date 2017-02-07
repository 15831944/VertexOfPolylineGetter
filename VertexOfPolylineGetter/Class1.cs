using Autodesk.AutoCAD.Runtime;
using Autodesk.AutoCAD.ApplicationServices;
using Autodesk.AutoCAD.DatabaseServices;
using Autodesk.AutoCAD.Geometry;

[assembly: CommandClass(typeof(VertexOfPolylineGetter.Class1))]

namespace VertexOfPolylineGetter
{
    public class Class1
    {
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

                int nCnt = 0;
                acDoc.Editor.WriteMessage("\nModel space objects: ");

                // Step through each object in Model space and
                // display the type of object found
                foreach (ObjectId acObjId in acBlkTblRec)
                {
                    acDoc.Editor.WriteMessage("\n" + acObjId.ObjectClass.Name + " - " + acObjId);

                    // work only with PolyLines
                    if (acObjId.ObjectClass.Name.Equals("AcDbPolyline"))
                    {
                        DBObject dbObject = acObjId.GetObject(OpenMode.ForRead);
                        Polyline pln = dbObject as Polyline;
                        int vn = pln.NumberOfVertices;
                        for (int i = 0; i < vn; i++)
                        {
                            // Could also get the 3D point here
                            Point2d pt = pln.GetPoint2dAt(i);
                            acDoc.Editor.WriteMessage("\n" + pt.X + " - " + pt.Y);
                        }
                    }

                    nCnt = nCnt + 1;
                }

                // If no objects are found then display a message
                if (nCnt == 0)
                {
                    acDoc.Editor.WriteMessage("\n  No objects found");
                }

                // Dispose of the transaction
            }
        }


        [CommandMethod("ListEntities")]
        public static void ListEntities()
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

                int nCnt = 0;
                acDoc.Editor.WriteMessage("\nModel space objects: ");

                // Step through each object in Model space and
                // display the type of object found
                foreach (ObjectId acObjId in acBlkTblRec)
                {
                    acDoc.Editor.WriteMessage("\n" + acObjId.ObjectClass.DxfName);

                    nCnt = nCnt + 1;
                }

                // If no objects are found then display a message
                if (nCnt == 0)
                {
                    acDoc.Editor.WriteMessage("\n  No objects found");
                }

                // Dispose of the transaction
            }
        }

        [CommandMethod("EditPolyline")]
        public static void EditPolyline()
        {
            // Get the current document and database
            Document acDoc = Application.DocumentManager.MdiActiveDocument;
            Database acCurDb = acDoc.Database;

            // Start a transaction
            using (Transaction acTrans = acCurDb.TransactionManager.StartTransaction())
            {
                // Open the Block table for read
                BlockTable acBlkTbl;
                acBlkTbl = acTrans.GetObject(acCurDb.BlockTableId,
                                                OpenMode.ForRead) as BlockTable;

                // Open the Block table record Model space for write
                BlockTableRecord acBlkTblRec;
                acBlkTblRec = acTrans.GetObject(acBlkTbl[BlockTableRecord.ModelSpace],
                                                OpenMode.ForWrite) as BlockTableRecord;

                // Create a lightweight polyline
                using (Polyline acPoly = new Polyline())
                {
                    acPoly.AddVertexAt(0, new Point2d(1, 1), 0, 0, 0);
                    acPoly.AddVertexAt(1, new Point2d(1, 2), 0, 0, 0);
                    acPoly.AddVertexAt(2, new Point2d(2, 2), 0, 0, 0);
                    acPoly.AddVertexAt(3, new Point2d(3, 2), 0, 0, 0);
                    acPoly.AddVertexAt(4, new Point2d(4, 4), 0, 0, 0);

                    // Add the new object to the block table record and the transaction
                    acBlkTblRec.AppendEntity(acPoly);
                    acTrans.AddNewlyCreatedDBObject(acPoly, true);

                    // Sets the bulge at index 3
                    acPoly.SetBulgeAt(3, -0.5);

                    // Add a new vertex
                    acPoly.AddVertexAt(5, new Point2d(4, 1), 0, 0, 0);

                    // Sets the start and end width at index 4
                    acPoly.SetStartWidthAt(4, 0.1);
                    acPoly.SetEndWidthAt(4, 0.5);

                    // Close the polyline
                    acPoly.Closed = true;
                }

                // Save the new objects to the database
                acTrans.Commit();
            }
        }

    }
}
