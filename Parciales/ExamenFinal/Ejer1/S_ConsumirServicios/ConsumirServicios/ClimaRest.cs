using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsumirServicios
{
    [Serializable]
    internal class ClimaRest
    {
        public int? id { get; set; }
        public string? fecha { get; set; }
        public int? temperatura { get; set; }
        public DateTime? created_at {  get; set; }
        public DateTime? updated_at { get; set; }

        public override string ToString()
        {
            return $"id: {id}, fecha: {fecha}, temperatura: {temperatura}, created_at: {created_at}, updated_at: {updated_at}\n";
        }
    }
}
