$(document).ready(function () {
    $('#status-table').DataTable({
        ajax: {
            url: 'api/status',
            dataSrc: ''
        },
        columns: [
            // {data: null,
            // render: function (data, type, row, meta) {
            //     return meta.row + meta.settings._iDisplayStart + 1;
            // }
            // },
            {
                data: 'id'
            },
            {
                data: 'name'
            },
            {
                "data": null,
                render: function (data, row, type, meta) {
                    return `
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailModal"
                        onclick="statusDetail(${data.id})">
                        <i class="bi bi-exclamation-circle-fill"></i>
                    </button>
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateModal"
                        onclick="beforeUpdate(${data.id})">
                        <i class="bi bi-pencil-square"></i>
                    </button>
                    <button type="button" class="btn btn-danger"
                        onclick="statusDelete(${data.id})">
                        <i class="bi bi-trash3-fill"></i>
                    </button>
                    `;
                }
            }
        ]
    });
    $.ajax({
        method: "GET",
        url: "api/status",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#status-input-name').append(
                    '<option value="' + value.id + '">' + value.name + '</option>'
                )
            })
        }
    });

    $.ajax({
        method: "GET",
        url: "api/status",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#status-update-name').append(
                    '<option value="' + value.id + '">' + value.name + '</option>'
                )
            })
        }
    }) 
});

$(document).ready({
    
})

function create() {
    let valName = $('#status-input-name').val();

    $.ajax({
        method: "POST",
        url: "api/status",
        dataType: "JSON",
        data: JSON.stringify({
            name: valName,
        }),
        contentType: "application/json",
        success: result => {
            console.log(result)
            $('#createModal').modal('hide')
            $('#status-table').DataTable().ajax.reload()
            Swal.fire({
                position: 'top-center',
                icon: 'success',
                title: 'Country has been saved',
                showConfirmButton: false,
                timer: 1500
            })
        }
    })
}

function beforeUpdate(id) {
    $.ajax({
        method: "GET",
        url: "api/status/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#status-update-id').val(`${result.id}`)
            $('#status-update-name').val(`${result.name}`)
        }
    })
}

function update() {
    let valId = $('#status-update-id').val()
    let valName = $('#status-update-name').val()

    Swal.fire({
        title: 'Are you sure?',
        text: "Do you want to change this status!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Update it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "PUT",
                url: "api/status/" + valId,
                dataType: "JSON",
                contentType: "application/json",
                data: JSON.stringify({
                    name: valName
                }),
                success: result => {
                    $('#updateModal').modal('hide')
                    $('#status-table').DataTable().ajax.reload()
                    Swal.fire({
                        position: 'top-center',
                        icon: 'success',
                        title: 'Successfully to Update',
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            })
        }
    })
}

function statusDelete(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be delete this status!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "DELETE",
                url: "api/status/" + id,
                dataType: "JSON",
                success: result => {
                    $('#status-table').DataTable().ajax.reload()
                    Swal.fire({
                        position: 'top-center',
                        icon: 'success',
                        title: 'Successfully to Delete',
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            })
        }
    })
}

function statusDetail(id) {
    $.ajax({
        method: "GET",
        url: "api/status/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#status-detail-id').text(`${result.id}`)
            $('#status-detail-name').text(`${result.name}`)
        }
    })
}