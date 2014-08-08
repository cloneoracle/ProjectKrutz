
var sqlite3 = require('sqlite3').verbose();

var file = '../EvolutionOfAndroidApplications.sqlite';
var db = new sqlite3.Database(file, sqlite3.OPEN_READONLY);

var apkProperties = 'rowid, Name, Version, Developer, Genre, UserRating, DatePublished, FileSize, LowerDownloads, UpperDownloads';

var mergeApkList = function (apks) {

	for (var i = 1; i < apks.length; i++) {
		
		if (apks[i - 1].Overpermissions == null) {
			apks[i - 1].Overpermissions = [];
		} else if (!(apks[i - 1].Overpermissions instanceof Array)) {
			apks[i - 1].Overpermissions = [apks[i - 1].Overpermissions];
		}

		if (apks[i - 1].Underpermissions == null) {
			apks[i - 1].Underpermissions = [];
		} else if (!(apks[i - 1].Underpermissions instanceof Array)) {
			apks[i - 1].Underpermissions = [apks[i - 1].Underpermissions];
		}

		if (apks[i - 1].rowid === apks[i].rowid) {
			if (apks[i].Overpermissions != null && apks[i - 1].Overpermissions.indexOf(apks[i].Overpermissions) == -1) {
				apks[i - 1].Overpermissions.push(apks[i].Overpermissions);
			}

			if (apks[i].Underpermissions != null && apks[i - 1].Underpermissions.indexOf(apks[i].Underpermissions) == -1) {
				apks[i - 1].Underpermissions.push(apks[i].Underpermissions);
			}

			apks.splice(i, 1);
			i--;
		}
	}

	return apks;

};

exports.getApk = function (req, res) {

	var query = 'SELECT apk.rowid, apk.Name, apk.Version, apk.Developer, apk.Genre, ' +
		'apk.UserRating, apk.DatePublished, apk.FileSize, apk.LowerDownloads, apk.UpperDownloads, ' +
		'p.Name as Overpermissions, p2.Name as Underpermissions ' +
		'FROM ApkInformation apk ' +
		'LEFT JOIN Overprivilege o ON apk.rowid = o.ApkId ' +
		'LEFT JOIN Underprivilege u ON apk.rowid = u.ApkId ' +
		'LEFT JOIN Permissions p on p.pid = o.PermissionId ' +
		'LEFT JOIN Permissions p2 on p2.pid = u.PermissionId ' +
		'WHERE apk.rowid IS ' + req.query.rowid;

	db.all(query, function (err, apks) {
		var apk = mergeApkList(apks)[0];
		res.send(apk);
	});

};

exports.getApkList = function (req, res) {

	var query = 'SELECT apk.rowid, apk.Name, apk.Version, apk.Developer, apk.Genre, ' +
		'apk.UserRating, apk.DatePublished, apk.FileSize, apk.LowerDownloads, apk.UpperDownloads, ' +
		'p.Name as Overpermissions, p2.Name as Underpermissions ' +
		'FROM ApkInformation apk ' +
		'LEFT JOIN Overprivilege o ON apk.rowid = o.ApkId ' +
		'LEFT JOIN Underprivilege u ON apk.rowid = u.ApkId ' +
		'LEFT JOIN Permissions p on p.pid = o.PermissionId ' +
		'LEFT JOIN Permissions p2 on p2.pid = u.PermissionId';

	db.all(query, function (err, apks) {
		res.send(mergeApkList(apks));
	});
};

// TODO: Maybe use this instead of topApk filter?
exports.getTopApkList = function (req, res) {

	// SELECT Name, Version, Developer, MAX(CollectionDate), UpperDownloads FROM ApkInformation GROUP BY Name ORDER BY UpperDownloads DESC LIMIT 10
	var query = 'SELECT apk.rowid, apk.Name, MAX(apk.CollectionDate), ' +
		'p.Name as Overpermissions, p2.Name as Underpermissions ' +
		'FROM ApkInformation apk ' +
		'LEFT JOIN Overprivilege o ON apk.rowid = o.ApkId ' +
		'LEFT JOIN Underprivilege u ON apk.rowid = u.ApkId ' +
		'LEFT JOIN Permissions p on p.pid = o.PermissionId ' +
		'LEFT JOIN Permissions p2 on p2.pid = u.PermissionId ' +
		'GROUP BY apk.Name ORDER BY apk.UpperDownloads DESC LIMIT 5';

	db.all(query, function (err, apks) {
		res.send(mergeApkList(apks));
	});

};

exports.getGenreList = function (req, res) {

	db.all('SELECT DISTINCT Genre FROM ApkInformation ORDER BY Genre', function (err, genres) {
		res.send(genres);
	});

};

exports.getFilteredApkList = function (req, res) {
	
	var statement = 'SELECT ' + apkProperties + ' FROM ApkInformation';

	if (req.query.name) {
		statement += ' WHERE Name LIKE "%' + req.query.name + '%"';
	}
	if (req.query.version) {
		statement += ' WHERE Version LIKE "%' + req.query.version + '%"';
	}
	if (req.query.developer) {
		statement += ' WHERE Developer LIKE "%' + req.query.developer + '%"';
	}
	if (req.query.genre) {
		statement += ' WHERE Genre LIKE"%' + req.query.genre + '%"';
	}
	if (req.query.userRatingFrom && req.query.userRatingTo) {
		statement += ' WHERE Rating BETWEEN ' + req.query.userRatingFrom + ' AND ' + req.query.userRatingTo;
	}
	// TODO: DatePublished and FileSize queries are not functional
	if (req.query.releaseDateFrom && req.query.releaseDateTo) {
		statement += ' WHERE DatePublished BETWEEN ' + req.query.releaseDateFrom + ' AND ' + req.query.releaseDateTo;
	}
	if (req.query.fileSizeFrom && req.query.fileSizeTo) {
		statement += ' WHERE FileSize BETWEEN "' + req.query.fileSizeFrom + req.query.fileSizeFromUnit + '" AND "' + req.query.fileSizeTo + req.query.fileSizeToUnit + '"';
	}

	db.all(statement, function (err, apks) {
		res.send(apks);
	});
	
};

exports.getOverprivilegeList = function (req, res) {

	db.all('SELECT * FROM Overprivilege', function (err, overpermissions) {
		res.send(overpermissions);
	})

};

exports.getUnderprivilegeList = function (req, res) {

	db.all('SELECT * FROM Underprivilege', function (err, underpermissions) {
		res.send(underpermissions);
	})

};
