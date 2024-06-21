<?php

namespace App\Http\Controllers;

use App\Models\Wheater;
use Illuminate\Http\Request;

class WheaterController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $wheater = Wheater::all();
        return response()->json($wheater, 200);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $wheater = Wheater::create($request->all());
        //dd($wheater);
        return response()->json($wheater, 201);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $wheater = Wheater::where('id', $id)->first();
        if (!$wheater) {
            return response()->json([
                'message' => 'clima no existe'
            ], 404);
        } else {
            return response()->json($wheater, 200);
        }
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $wheater = Wheater::find($id);
        if (!$wheater) {
            return response()->json([
                'message' => 'Registro no encontrado'
            ], 404);
        }

        $wheater->update(request()->all());

        return response()->json([
            'message' => 'Registro de clima actualizado correctamente',
            'wheater' => $wheater
        ], 200);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $wheater = Wheater::find($id);
        if (!$wheater) {
            return response()->json([
                'message' => 'Registro no encontrado'
            ], 404);
        }

        $wheater->delete();

        return response()->json([
            'message' => 'Registro eliminado correctamente',
            'wheater' => $wheater
        ], 201);
    }
}
