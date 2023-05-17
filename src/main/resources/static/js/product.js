$(document).ready(function () {
    $('#product-table').DataTable({
        ajax: {
            url: 'api/product',
            dataSrc: ''
        },
        columns: [
            {
                data: 'id'
            },
            {
                data: 'name'
            },
            {
                data: 'quantity'
            },
            {
                data: 'category.name'
            },
            {
                data: 'user.username'
            },
            {
                data: 'description'
            },
            {
                "data": null,
                render: function (data, row, type, meta) {
                    return `
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailModal"
                        onclick="productDeatil(${data.id})">
                        <i class="bi bi-exclamation-circle-fill"></i>
                    </button>
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateModal"
                        onclick="beforeUpdate(${data.id})">
                        <i class="bi bi-pencil-square"></i>
                    </button>
                    <button type="button" class="btn btn-danger"
                        onclick="productDelete(${data.id})">
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
        url: "api/user",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#user-input-name').append(
                    '<option value="' + value.id + '">' + value.username + '</option>'
                )
                })
            }
        }) 
    });

$(document).ready({
    
})

function create() {
    let valId = $('#product-input-id').val();
    let valName = $('#product-input-name').val();
    let valQuan = $('#product-input-quantity').val();
    let valCat = $('#category-input-name option:selected').val();
    let valUser = $('#user-input-name option:selected').val();
    let valDesc = $('#product-input-description').val();

    $.ajax({
        method: "POST",
        url: "api/product",
        dataType: "JSON",
        data: JSON.stringify({
            id: valId,
            name: valName,
            quantity: valQuan,
            category: {
                id: valCat
            },
            user: {
                id: valUser
            },
            description: valDesc
        }),
        contentType: "application/json",
        success: result => {
            console.log(result)
            $('#createModal').modal('hide')
            $('#product-table').DataTable().ajax.reload()
            Swal.fire({
                position: 'top-center',
                icon: 'success',
                title: 'Product has been saved',
                showConfirmButton: false,
                timer: 1500
            })
        }
    })
}

function beforeUpdate(id) {
    $.ajax({
        method: "GET",
        url: "api/product/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#product-update-id').text(`${result.id}`)
            $('#product-update-name').text(`${result.name}`)
            $('#product-update-quantity').text(`${result.quantity}`)
            $('#category-update-name').text(`${result.category.name}`)
            $('#user-update-name').text(`${result.user.username}`)
            $('#product-update-description').text(`${result.description}`)
        }
    })
}

function update() {
    let valId = $('#product-update-id').val();
    let valName = $('#product-update-name').val();
    let valQuan = $('#product-update-quantity').val();
    let valCat = $('#category-update-name option:selected').val();
    let valUser = $('#user-update-name option:selected').val();
    let valDesc = $('#product-update-description').val();

    Swal.fire({
        title: 'Are you sure?',
        text: "Do you want to change this product!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Update it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "PUT",
                url: "api/product/" + valId,
                dataType: "JSON",
                contentType: "application/json",
                data: JSON.stringify({
                    id: valId,
                    name: valName,
                    quantity: valQuan,
                    category: {
                        id: valCat
                    },
                    user: {
                        id: valUser
                    },
                    description: valDesc
                }),
                success: result => {
                    $('#updateModal').modal('hide')
                    $('#product-table').DataTable().ajax.reload()
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

function productDelete(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be delete this product!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "DELETE",
                url: "api/product/" + id,
                dataType: "JSON",
                success: result => {
                    $('#product-table').DataTable().ajax.reload()
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

function productDeatil(id) {
    $.ajax({
        method: "GET",
        url: "api/product/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#product-detail-id').text(`${result.id}`)
            $('#product-detail-name').text(`${result.name}`)
            $('#product-detail-quantity').text(`${result.quantity}`)
            $('#category-detail-name').text(`${result.category.name}`)
            $('#user-detail-name').text(`${result.user.username}`)
            $('#product-detail-description').text(`${result.description}`)
        }
    })
}