namespace VertexOfPolylineGetter.xmlPackadge
{
    public class Railyard : RailRoadElement
    {
        public Railyard()
        {
        }

        public Railyard(string railyardId, string railyardName, int railyardX, int railyardY)
        {
            Id = railyardId;
            Name = railyardName;
            X = railyardX;
            Y = railyardY;
        }

        public Shapes Shapes { get; set; }
    }
}