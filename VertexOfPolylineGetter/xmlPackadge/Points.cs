using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace VertexOfPolylineGetter.xmlPackadge
{
    public class Points
    {
        public Points()
        {
        }

        [XmlElement("Point")]
        public List<Point> PointsList { get; set; }
    }
}
