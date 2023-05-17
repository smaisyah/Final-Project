$(document).ready(function () {
    $('#role-table').DataTable({
        ajax: {
            url: 'api/role',
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
                        onclick="roleDetail(${data.id})">
                        <i class="bi bi-exclamation-circle-fill"></i>
                    </button>
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateModal"
                        onclick="beforeUpdate(${data.id})">
                        <i class="bi bi-pencil-square"></i>
                    </button>
                    <button type="button" class="btn btn-danger"
                        onclick="roleDelete(${data.id})">
                        <i class="bi bi-trash3-fill"></i>
                    </button>
                    `;
                }
            }
        ]
    });
    $.ajax({
        method: "GET",
        url: "api/role",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#role-input-name').append(
                    '<option value="' + value.id + '">' + value.name + '</option>'
                )
            })
        }
    });

    $.ajax({
        method: "GET",
        url: "api/role",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#role-update-name').append(
                    '<option value="' + value.id + '">' + value.name + '</option>'
                )
            })
        }
    }) 
});

$(document).ready({
    
})

function create() {
    let valName = $('#role-input-name').val();

    $.ajax({
        method: "POST",
        url: "api/role",
        dataType: "JSON",
        data: JSON.stringify({
            name: valName,
        }),
        contentType: "application/json",
        success: result => {
            console.log(result)
            $('#createModal').modal('hide')
            $('#role-table').DataTable().ajax.reload()
            Swal.fire({
                position: 'top-center',
                icon: 'success',
                title: 'Role has been saved',
                showConfirmButton: false,
                timer: 1500
            })
        }
    })
}

function beforeUpdate(id) {
    $.ajax({
        method: "GET",
        url: "api/role/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#role-update-id').val(`${result.id}`)
            $('#role-update-name').val(`${result.name}`)
        }
    })
}

function update() {
    let valId = $('#role-update-id').val()
    let valName = $('#role-update-name').val()

    Swal.fire({
        title: 'Are you sure?',
        text: "Do you want to change this role!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Update it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "PUT",
                url: "api/role/" + valId,
                dataType: "JSON",
                contentType: "application/json",
                data: JSON.stringify({
                    name: valName
                }),
                success: result => {
                    $('#updateModal').modal('hide')
                    $('#role-table').DataTable().ajax.reload()
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

function roleDelete(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be delete this role!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "DELETE",
                url: "api/role/" + id,
                dataType: "JSON",
                success: result => {
                    $('#role-table').DataTable().ajax.reload()
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

function roleDetail(id) {
    $.ajax({
        method: "GET",
        url: "api/role/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#role-detail-id').text(`${result.id}`)
            $('#role-detail-name').text(`${result.name}`)
        }
    })
}