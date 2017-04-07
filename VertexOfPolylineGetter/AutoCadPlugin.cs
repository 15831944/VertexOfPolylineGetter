using System.Collections.Generic;
using System.Reflection;
using System.Text;
using Autodesk.AutoCAD.Runtime;
using Autodesk.AutoCAD.ApplicationServices;
using Autodesk.AutoCAD.DatabaseServices;
using Autodesk.AutoCAD.Geometry;
using VertexOfPolylineGetter.xmlPackadge;

[assembly: CommandClass(typeof(VertexOfPolylineGetter.AutoCadPlugin))]

namespace VertexOfPolylineGetter
{
    public class AutoCadPlugin
    {
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

                acDoc.Editor.WriteMessage("\n--------------------------------------------------------------------------------------------");
                acDoc.Editor.WriteMessage("\nHi! I'm command getPolylineVertex.");
                acDoc.Editor.WriteMessage("\nI'll scan this model space and find all objects.");
                acDoc.Editor.WriteMessage("\nIf I'll find Polylines or vertexies I'll make AnyLogic network in xml format");
                acDoc.Editor.WriteMessage("\ngetPolylineVertex start working...");

                NetworkMaker networkMaker = new NetworkMaker(acBlkTblRec);
                Shapes mainShapes = networkMaker.MakeShapes();

                if (mainShapes == null)
                {
                    acDoc.Editor.WriteMessage("\nNetworkMaker:  Couldn't make shapes!");
                }
                else
                {
                    acDoc.Editor.WriteMessage("\nNetworkMaker: done!");
                }

                // Dispose of the transaction
                acDoc.Editor.WriteMessage("\ngetPolylineVertex done!");
                acDoc.Editor.WriteMessage("\n--------------------------------------------------------------------------------------------");
            }
        }
    }
}
