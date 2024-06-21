using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsumirServicios
{
    [Serializable]
    internal class wheater
    {
        public string? id { get; set; }
        public string? fecha { get; set; }
        public string? temperatura { get; set; }

        public override string ToString()
        {
            return $"id: {id}, fecha: {fecha}, temperatura: {temperatura}\n";
        }
    }

    [Serializable]
    internal class Data
    {
        public List<wheater> wheaters { get; set; }
    }

    [Serializable]
    internal class ClimaResponse
    {
        public Data data { get; set; }
    }
}
