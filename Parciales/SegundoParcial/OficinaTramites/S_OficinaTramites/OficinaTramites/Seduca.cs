using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OficinaTramites
{
    internal class Seduca
    {
        public string? ci { get; set; }
        public string? apellidos { get; set; }
        public string? nombres { get; set; }
        public Boolean? Bachiller { get; set; }

        public override string ToString()
        {
            return $"ci: {ci}, Apellidos: {apellidos}, Nombres: {nombres}, Bachiller:{Bachiller}";
        }
    }
}
