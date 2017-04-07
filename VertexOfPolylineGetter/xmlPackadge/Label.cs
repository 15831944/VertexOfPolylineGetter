using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VertexOfPolylineGetter.xmlPackadge
{
    class Label
    {
        private int _x;
        private int _y;

        public int X
        {
            get { return _x; }
            set { _x = Constants.LabelX; }
        }

        public int Y
        {
            get
            {
                return _y;
            }

            set
            {
                _y = Constants.LabelY;
            }
        }
    }
}
