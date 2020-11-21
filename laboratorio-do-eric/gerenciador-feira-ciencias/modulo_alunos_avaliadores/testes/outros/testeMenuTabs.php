<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      *{
        margin: 0;
        padding: 0;
      }
      body{
        background-color: #ddd;
        font-family: 'Arial';
      }
      .nav-tabs{
        width: 600px;
        height: 400px;
        margin: 100px auto;
        background-color: #fff;
        position: relative;
      }
      .nav-tabs ul{
        list-style: none;
      }
      .nav-tabs ul li{
        float: left;
      }
      .nav-tabs label{
        width: 100px;
        padding: 25px;
        background-color: #363b48;
        display: block;
        color: #fff;
        cursor: pointer;
        text-align: center;
      }
      .rd-tabs:checked ~ label{
        background-color: #e54e43;
      }
      .rd-tabs{
        display: none;
      }
      .content{
        border-top: 5px solid #e54e43;
        background-color: #fff;
        display: none;
        position: absolute;
        height: 320px;
        width: 600px;
        left: 0;
      }
      .rd-tabs:checked ~ .content{
        display: block;
      }
      .content article{
        padding: 10px;
      }
    </style>
  </head>
  <body>
    <nav class="nav-tabs">
      <ul>
        <li>
          <input type="radio" name="tabs" class="rd-tabs" id="tab-1" checked>
          <label for="tab-1">Tab 1</label>
          <div class="content">
            <article>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </article>
          </div>
        </li>
        <li>
          <input type="radio" name="tabs" class="rd-tabs" id="tab-2" checked>
          <label for="tab-2">Tab 2</label>
          <div class="content">
            <article>
              Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?
            </article>
          </div>
        </li>
        <li>
          <input type="radio" name="tabs" class="rd-tabs" id="tab-3" checked>
          <label for="tab-3">Tab 3</label>
          <div class="content">
            <article>
              But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure
            </article>
          </div>
        </li>
        <li>
          <input type="radio" name="tabs" class="rd-tabs" id="tab-4" checked>
          <label for="tab-4">Tab 4</label>
          <div class="content">
            <article>
              At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.
            </article>
          </div>
        </li>
      </ul>
    </nav>
  </body>
</html>
