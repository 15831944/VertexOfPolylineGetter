namespace VertexOfPolylineGetter.xmlPackadge
{
    public class RailRoadElement
    {
        private bool _publicFlag;
        private bool _presentationFlag;
        private bool _showLabel;
        private string _drawMode;

        public string Id { get; set; }
        public string Name { get; set; }
        public int X { get; set; }
        public int Y { get; set; }

        public bool PublicFlag
        {
            get { return _publicFlag; }
            set { _publicFlag = Constants.PublicFlag; }
        }

        public bool PresentationFlag
        {
            get { return _presentationFlag; }
            set { _presentationFlag = Constants.PresentationFlag; }
        }

        public bool ShowLabel
        {
            get { return _showLabel; }
            set { _showLabel = Constants.ShowLabel; }
        }

        public string DrawMode
        {
            get { return _drawMode; }
            set { _drawMode = Constants.DrawMode; }
        }
    }
}