using System.Collections.Generic;
using System.Xml.Serialization;

namespace VertexOfPolylineGetter.xmlPackadge
{
    public class Shapes
    {
        // default constructor for serialisation
        public Shapes()
        {
        }

        [XmlElement("Railyard")]
        public List<Railyard> RailyardsList { get; set; }

        [XmlElement("RailTrack")]
        public List<RailTrack> RailTracksList { get; set; }

        [XmlElement("RailroadSwitch")]
        public List<RailroadSwitch> RailroadSwitchesList { get; set; }
    }
}