using Microsoft.VisualBasic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClienteReserva
{
    public class bancocentral
    {
        public string? fecha { get; set; }
        public string? cotizacion { get; set; }

        public override string ToString()
        {
            return $"Fecha: {fecha}, Cotización: {cotizacion}";
        }

    }

    
}
