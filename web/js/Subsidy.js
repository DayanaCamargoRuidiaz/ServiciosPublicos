function cargarFormulario(id,name,description,startDate,endDate,waterValue,naturalGasWater,energyValue, type){
    $("#idSybsudy").val(id);
    $("#name").val(name);
    $("#description").val(description);
    $("#startDate").val(startDate);
    $("#endDate").val(endDate);
    $("#expectedNaturalGasValue").val(naturalGasWater);
    $("#expectedWaterValue").val(waterValue);
    $("#expectedEnergyValue").val(energyValue);
    $("#type").val(type);
    $("#myModal").modal();
}