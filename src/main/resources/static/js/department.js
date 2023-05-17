$(document).ready(function () {
    $('#department-table').DataTable({
        ajax: {
            url: 'api/department',
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
                data: 'budget'
            },
            {
                "data": null,
                render: function (data, row, type, meta) {
                    return `
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailModal"
                        onclick="departmentDetail(${data.id})">
                        <i class="bi bi-exclamation-circle-fill"></i>
                    </button>
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateModal"
                        onclick="beforeUpdate(${data.id})">
                        <i class="bi bi-pencil-square"></i>
                    </button>
                    <button type="button" class="btn btn-danger"
                        onclick="departmentDelete(${data.id})">
                        <i class="bi bi-trash3-fill"></i>
                    </button>
                    `;
                }
            }
        ]
    });

    $.ajax({
        method: "GET",
        url: "api/department",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#department-update-name').append(
                    '<option value="' + value.id + '">' + value.name + '</option>'
                )
            })
        }
    }) 
});

$(document).ready({
    
})

function create() {
    let valId = $('#department-input-id').val();
    let valName = $('#department-input-name').val();
    let valBudget = $('#department-input-budget').val();

    $.ajax({
        method: "POST",
        url: "api/department",
        dataType: "JSON",
        data: JSON.stringify({
            id: valId,
            name: valName,
            budget: valBudget
        }),
        contentType: "application/json",
        success: result => {
            console.log(result)
            $('#createModal').modal('hide')
            $('#department-table').DataTable().ajax.reload()
            Swal.fire({
                position: 'top-center',
                icon: 'success',
                title: 'Department has been saved',
                showConfirmButton: false,
                timer: 1500
            })
        }
    })
}

function beforeUpdate(id) {
    $.ajax({
        method: "GET",
        url: "api/department/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#department-update-id').val(`${result.id}`)
            $('#department-update-name').val(`${result.name}`)
            $('#department-update-budget').val(`${result.budget}`)
        }
    })
}

function update() {
    let valId = $('#department-update-id').val()
    let valName = $('#department-update-name').val()
    let valBudget = $('#department-update-budget').val()

    Swal.fire({
        title: 'Are you sure?',
        text: "Do you want to change this department!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Update it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "PUT",
                url: "api/department/" + valId,
                dataType: "JSON",
                contentType: "application/json",
                data: JSON.stringify({
                    name: valName,
                    budget: valBudget
                }),
                success: result => {
                    $('#updateModal').modal('hide')
                    $('#department-table').DataTable().ajax.reload()
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

function departmentDelete(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be delete this department!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "DELETE",
                url: "api/department/" + id,
                dataType: "JSON",
                success: result => {
                    $('#department-table').DataTable().ajax.reload()
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

function departmentDetail(id) {
    $.ajax({
        method: "GET",
        url: "api/department/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#department-detail-id').text(`${result.id}`)
            $('#department-detail-name').text(`${result.name}`)
            $('#department-detail-budget').text(`${result.budget}`)
        }
    })
}