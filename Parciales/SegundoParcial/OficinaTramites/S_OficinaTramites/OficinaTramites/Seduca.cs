using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OficinaTramites
{
    [Serializable]
    internal class Qualification
    {
        public string? ci { get; set; }
        public string? apellidos { get; set; }
        public string? nombres { get; set; }
        public Boolean? Bachiller { get; set; }

        public override string ToString()
        {
            return $"ci: {ci}, Apellidos: {apellidos}, Nombres: {nombres}, Bachiller: {Bachiller}";
        }
    }

    [Serializable]
    internal class Data
    {
        public Qualification qualification { get; set; }
    }

    [Serializable]
    internal class SeducaResponse
    {
        public Data data { get; set; }
    }
}
