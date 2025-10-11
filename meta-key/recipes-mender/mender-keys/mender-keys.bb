SUMMARY = "Mender public key package"
DESCRIPTION = "Provides the Mender public key for artifact verification"
LICENSE = "CLOSED"
PR = "r0"

SRC_URI = "file://*"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/mender

    # Copier toutes les clés présentes dans le répertoire files/
    for key in ${WORKDIR}/*.pem; do
        install -m 0644 ${key} ${D}${sysconfdir}/mender/
    done
}

FILES_${PN} = "${sysconfdir}/mender/*.pem"
