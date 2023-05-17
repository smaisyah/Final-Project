$(document).ready(function () {
    $('#category-table').DataTable({
        ajax: {
            url: 'api/category',
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
                        onclick="categoryDetail(${data.id})">
                        <i class="bi bi-exclamation-circle-fill"></i>
                    </button>
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateModal"
                        onclick="beforeUpdate(${data.id})">
                        <i class="bi bi-pencil-square"></i>
                    </button>
                    <button type="button" class="btn btn-danger"
                        onclick="categoryDelete(${data.id})">
                        <i class="bi bi-trash3-fill"></i>
                    </button>
                    `;
                }
            }
        ]
    });
    $.ajax({
        method: "GET",
        url: "api/category",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#category-input-name').append(
                    '<option value="' + value.id + '">' + value.name + '</option>'
                )
            })
        }
    });

    $.ajax({
        method: "GET",
        url: "api/category",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#category-update-name').append(
                    '<option value="' + value.id + '">' + value.name + '</option>'
                )
            })
        }
    }) 
});

$(document).ready({
    
})

function create() {
    let valName = $('#category-input-name').val();

    $.ajax({
        method: "POST",
        url: "api/category",
        dataType: "JSON",
        data: JSON.stringify({
            name: valName,
        }),
        contentType: "application/json",
        success: result => {
            console.log(result)
            $('#createModal').modal('hide')
            $('#category-table').DataTable().ajax.reload()
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
        url: "api/category/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#category-update-id').val(`${result.id}`)
            $('#category-update-name').val(`${result.name}`)
        }
    })
}

function update() {
    let valId = $('#category-update-id').val()
    let valName = $('#category-update-name').val()

    Swal.fire({
        title: 'Are you sure?',
        text: "Do you want to change this category!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Update it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "PUT",
                url: "api/category/" + valId,
                dataType: "JSON",
                contentType: "application/json",
                data: JSON.stringify({
                    name: valName
                }),
                success: result => {
                    $('#updateModal').modal('hide')
                    $('#category-table').DataTable().ajax.reload()
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

function categoryDelete(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be delete this category!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "DELETE",
                url: "api/category/" + id,
                dataType: "JSON",
                success: result => {
                    $('#category-table').DataTable().ajax.reload()
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

function categoryDetail(id) {
    $.ajax({
        method: "GET",
        url: "api/category/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#category-detail-id').text(`${result.id}`)
            $('#category-detail-name').text(`${result.name}`)
        }
    })
}