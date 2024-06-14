using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OficinaTramites
{
    [Serializable]
    internal class Academico
    {
        public string? ci { get; set; }
        public string? nombre_completo { get; set; }
        public string? titulo { get; set; }
        public DateTime? fecha_emision { get; set; }

        public override string ToString()
        {
            return $"ci: {ci}, NombreCompleto: {nombre_completo}, titulo: {titulo}, fecha_emision:{fecha_emision}";
        }
    }
}
