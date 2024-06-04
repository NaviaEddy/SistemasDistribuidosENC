<?php

namespace App\Http\Controllers\Api\v1;

use App\Http\Controllers\Controller;
use App\Models\Invoice;
use Illuminate\Http\Request;

class InvoiceController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $invoice = Invoice::all();
        return response()->json($invoice, 200);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $request->validate([
            'nro' => 'required',
            'fecha' => 'required',
            'cuf' => 'required|string|max:30',
            'cufd' => 'required|string|max:30',
            'MontoTotal' => 'required|numeric',
        ]);
        $invoice = Invoice::create($request->all());
        return response()->json($invoice, 201);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $invoice = Invoice::find($id);
        if(!$invoice) {
            return response()->json([
                'message' => 'Registro no encontrado'
            ], 404);
        }else{
            return response()->json($invoice, 200);
        }
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $invoice = Invoice::find($id);
        if (!$invoice) {
            return response()->json([
                'message' => 'Registro no encontrado'
            ], 404);
        }
    
        // Diferenciar entre PUT y PATCH
        if ($request->isMethod('patch')) {
            $input = $request->only(['nro', 'fecha', 'cuf', 'cufd', 'MontoTotal']);
        } else {
            $input = $request->all();
        }
    
        $invoice->fill($input);
        $invoice->save();
    
        return response()->json([
            'message' => 'Registro actualizado correctamente',
            'department' => $invoice
        ], 200);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $invoice = Invoice::find($id);
        $invoice->delete();

        return response()->json([
            'message' => 'Registro eliminado correctamente',
            'department' => $invoice
        ], 201);
    }
}
