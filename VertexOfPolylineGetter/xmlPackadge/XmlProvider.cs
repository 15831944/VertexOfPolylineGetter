using System;
using System.IO;
using System.Xml.Serialization;

namespace VertexOfPolylineGetter.xmlPackadge
{
    /// <summary>
    /// XmlSerializer
    /// </summary>
    public class XmlProvider : IShapesProvider
    {
        private string _fullFileName;

        public XmlProvider(string fileName)
        {
            _fullFileName = Path.Combine(Environment.CurrentDirectory, fileName);
        }

        public void SaveShapes(Shapes shapes)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(Shapes));
            using (StreamWriter sw = new StreamWriter(_fullFileName))
            {
                serializer.Serialize(sw, shapes);
            }
        }
    }
}