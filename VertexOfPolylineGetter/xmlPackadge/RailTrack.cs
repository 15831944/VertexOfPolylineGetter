using Autodesk.AutoCAD.DatabaseServices;

namespace VertexOfPolylineGetter.xmlPackadge
{
    public class RailTrack : RailRoadElement
    {
        private int _z;
        private long _lineColor;
        private string _lineMaterial;
        private string _pathType;
        private int _width;
        private bool _bidirectional;

        public int Z
        {
            get { return _z; }
            set { _z = Constants.Z; }
        }

        public long LineColor
        {
            get { return _lineColor; }
            set { _lineColor = Constants.LineColor; }
        }

        public string LineMaterial
        {
            get { return _lineMaterial; }
            set { _lineMaterial = Constants.LineMaterial; }
        }

        public string PathType
        {
            get { return _pathType; }
            set { _pathType = Constants.PathType; }
        }

        public int Width
        {
            get { return _width; }
            set { _width = Constants.Width; }
        }

        public Points Points { get; set; }

        public bool Bidirectional
        {
            get { return _bidirectional; }
            set { _bidirectional = Constants.Bidirectional; }
        }

        public RailTrack(string id, string name, int x, int y, Points points)
        {
            Id = id;
            Name = name;
            X = x;
            Y = y;
            Points = points;
        }

        public RailTrack()
        {
            
        }
    }
}